/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2018 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2018 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.oce.engine.itest;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opennms.oce.datasource.api.Alarm;
import org.opennms.oce.datasource.api.Incident;
import org.opennms.oce.datasource.api.InventoryObject;
import org.opennms.oce.datasource.api.ResourceKey;
import org.opennms.oce.datasource.api.Severity;
import org.opennms.oce.driver.test.MockAlarmBuilder;
import org.opennms.oce.driver.test.MockInventory;
import org.opennms.oce.driver.test.TestDriver;
import org.opennms.oce.engine.api.EngineFactory;
import org.opennms.oce.engine.topology.TopologyEngineFactory;

public class TopologyResumeServiceTest {

    private List<InventoryObject> inventory = MockInventory.SAMPLE_NETWORK;

    private final EngineFactory factory = new TopologyEngineFactory();

    private TestDriver baseDriver;

    private TestDriver aprioriDriver;

    private TestDriver testDriver;

    @Before
    public void setUp() {
        baseDriver = TestDriver.builder().withEngineFactory(factory).build();
        aprioriDriver = TestDriver.builder().withEngineFactory(factory).build();
        testDriver = TestDriver.builder().withEngineFactory(factory).build();
    }

    @Test
    public void resumeServiceBetweenTwoAlarmsTest() {
        final List<Alarm> alarms = new ArrayList<>();
        // Fail all ports on all cards of node: n1
        alarms.addAll(new MockAlarmBuilder().withId("a1").withResourceKey(new ResourceKey("Port,n1-c1-p1"))
            .withEvent(SECONDS.toMillis(1), Severity.MAJOR).build());
        alarms.addAll(new MockAlarmBuilder().withId("a2").withResourceKey(new ResourceKey("Port,n1-c1-p2"))
            .withEvent(SECONDS.toMillis(31), Severity.MAJOR).build());

        List<Alarm> sortedAlarms = TestDriver.timeSortAlarms(alarms);
        final List<Incident> baseIncidents = baseDriver.run(sortedAlarms, inventory);

        // Now Split the run over a new driver
        // Resumption Time after First Alarm, Before Second
        long startUpTime = SECONDS.toMillis(15);
        List<Incident> priorIncidents = aprioriDriver.run(TestDriver.getStartupAlarms(sortedAlarms, startUpTime), inventory);

        final List<Incident> testIncidents = testDriver.run(sortedAlarms, inventory, priorIncidents, SECONDS.toMillis(15));

        // The test is useless if the baseline doesn't have Incidents
        assertThat(baseIncidents.size(), greaterThan(0));
        // Expect 1 incident after resumption
        assertThat(testIncidents.size(), equalTo(1));
        assertThat(testIncidents.get(0).getSeverity(), equalTo(Severity.CRITICAL));
    }

    @Test
    public void resumeServiceAfterIncidentTest() {
        final List<Alarm> alarms = new ArrayList<>();
        // Fail all ports on all cards of node: n1
        alarms.addAll(new MockAlarmBuilder().withId("a1").withResourceKey(new ResourceKey("Port,n1-c1-p1"))
            .withEvent(SECONDS.toMillis(1), Severity.MAJOR).withEvent(SECONDS.toMillis(301), Severity.CLEARED) // 5 minutes later
            .build());
        alarms.addAll(new MockAlarmBuilder().withId("a2").withResourceKey(new ResourceKey("Port,n1-c1-p2"))
            .withEvent(SECONDS.toMillis(31), Severity.MAJOR).withEvent(SECONDS.toMillis(331), Severity.CLEARED) // 5 minutes later
            .build());

        List<Alarm> sortedAlarms = TestDriver.timeSortAlarms(alarms);
        final List<Incident> baseIncidents = baseDriver.run(sortedAlarms, inventory);

        // Now Split the run over a new driver
        // But Resume Time is now after both alarms  
        long startUpTime = SECONDS.toMillis(120);

        // Don't pass any prior Incidents - Engine shoudl regenerate them
        final List<Incident> testIncidents = testDriver.run(sortedAlarms, inventory, Collections.emptyList(), startUpTime);

        // The test is useless if the baseline doesn't have Incidents
        assertThat(baseIncidents.size(), greaterThan(0));
        // Expect 2 incident after resumption
        assertThat(testIncidents.size(), equalTo(2));
        assertThat(testIncidents.get(0).getSeverity(), equalTo(Severity.CRITICAL));
        assertThat(testIncidents.get(1).getSeverity(), equalTo(Severity.CLEARED));
    }

    @Test
    public void resumeServiceIncludeIncidentTest() {
        final List<Alarm> alarms = new ArrayList<>();
        // Fail all ports on all cards of node: n1
        alarms.addAll(new MockAlarmBuilder().withId("a1").withResourceKey(new ResourceKey("Port,n1-c1-p1"))
            .withEvent(SECONDS.toMillis(1), Severity.MAJOR).withEvent(SECONDS.toMillis(301), Severity.CLEARED) // 5 minutes later
            .build());
        alarms.addAll(new MockAlarmBuilder().withId("a2").withResourceKey(new ResourceKey("Port,n1-c1-p2"))
            .withEvent(SECONDS.toMillis(31), Severity.MAJOR).withEvent(SECONDS.toMillis(331), Severity.CLEARED) // 5 minutes later
            .build());

        List<Alarm> sortedAlarms = TestDriver.timeSortAlarms(alarms);
        final List<Incident> baseIncidents = baseDriver.run(sortedAlarms, inventory);

        // Now Split the run over a new driver
        // But Resume Time is now after both alarms  
        long startUpTime = SECONDS.toMillis(120);
        List<Incident> priorIncidents = aprioriDriver.run(TestDriver.getStartupAlarms(sortedAlarms, startUpTime), inventory);

        final List<Incident> testIncidents = testDriver.run(sortedAlarms, inventory, priorIncidents, startUpTime);

        // The test is useless if the baseline doesn't have Incidents
        assertThat(baseIncidents.size(), greaterThan(0));
        // Expect 1 incident after resumption - just the CLEAR
        assertThat(testIncidents.size(), equalTo(1));
        assertThat(testIncidents.get(0).getSeverity(), equalTo(Severity.CLEARED));
    }

}
