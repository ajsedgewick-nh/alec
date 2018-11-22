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

package org.opennms.oce.datasource.opennms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;
import org.opennms.oce.datasource.api.Alarm;
import org.opennms.oce.datasource.api.Severity;
import org.opennms.oce.datasource.opennms.proto.OpennmsModelProtos;

public class OpennmsMapperTest {

    @Test
    public void canMapAlarms() {
        // Map an empty alarm and make sure no exceptions are thrown
        OpennmsModelProtos.Alarm alarm = OpennmsModelProtos.Alarm.newBuilder()
                .build();
        OpennmsMapper.toAlarm(alarm);

        // Now map a complete alarm and verify all of the properties
        alarm = OpennmsModelProtos.Alarm.newBuilder()
                .setReductionKey("nodeLostService::1")
                .setLastEventTime(2)
                .setSeverity(OpennmsModelProtos.Severity.CRITICAL)
                .setNodeCriteria(OpennmsModelProtos.NodeCriteria.newBuilder()
                        .setForeignSource("FS")
                        .setForeignId("FID")
                        .setId(22)
                        .build())
                .build();
        Alarm mappedAlarm = OpennmsMapper.toAlarm(alarm);
        assertThat(mappedAlarm.getId(), equalTo(alarm.getReductionKey()));
        assertThat(mappedAlarm.getTime(), equalTo(alarm.getLastEventTime()));
        assertThat(mappedAlarm.getSeverity(), equalTo(Severity.CRITICAL));
    }


}
