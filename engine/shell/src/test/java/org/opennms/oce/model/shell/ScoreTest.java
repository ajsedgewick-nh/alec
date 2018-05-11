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
package org.opennms.oce.model.shell;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Ignore;
import org.junit.Test;
import org.opennms.oce.engine.shell.Score;

public class ScoreTest {

    @Test
    public void testSameAccuracy100() throws Exception {
        Path baseline = Paths.get("src", "test", "resources", "Baseline.xml");
        Score score = new Score(baseline, baseline);
        // Test for Incidents
        assertEquals(100, score.getAccuracy());
        assertEquals(0, score.getTypeOneErrorCount());
        assertEquals(0, score.getFalseNegativeCount());
        // Test for Alarms coverage
        assertEquals(100, score.getAlarmAccuracy());
    }

    @Test
    public void testSeventyPercentAccuracy() throws Exception {
        Path baseline = Paths.get("src", "test", "resources", "Baseline.xml");
        Path seventyPercent = Paths.get("src", "test", "resources", "TwentyPercent.xml");
        Score score = new Score(baseline, seventyPercent);
        // Test for Incidents
        assertEquals(24, score.getAccuracy());
        assertEquals(1, score.getTypeOneErrorCount());
        assertEquals(63, score.getFalseNegativeCount());
        // Test for Alarms coverage
        assertEquals(26, score.getAlarmAccuracy());
    }

    @Ignore
    @Test
    public void testProcessor() throws Exception {
        Path baseline = Paths.get("src", "test", "resources", "cpn.incidents.xml");
        Path seventyPercent = Paths.get("src", "test", "resources", "incidents.xml");
        Score score = new Score(baseline, seventyPercent);
        // Output scores:
        System.out.println("Accuracy (%): " + score.getAccuracy());
        System.out.println("False Positives: " + score.getTypeOneErrorCount());
        System.out.println("False Negatives: " + score.getFalseNegativeCount());
        System.out.println("AlarmAccuracy (%): " + score.getAlarmAccuracy());
    }
}
