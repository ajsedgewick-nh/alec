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

package org.opennms.oce.engine.cluster;

import org.opennms.oce.engine.api.EngineFactory;

public class ClusterEngineFactory implements EngineFactory {
    private double epsilon = 1000d;
    private double timeWeight = 1/1000d;
    private double hopWeight = 1;

    @Override
    public String getName() {
        return "cluster";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public ClusterEngine createEngine() {
        return new ClusterEngine(epsilon, timeWeight, hopWeight);
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getTimeWeight() {
        return timeWeight;
    }

    public void setTimeWeight(double timeWeight) {
        this.timeWeight = timeWeight;
    }

    public double getHopWeight() {
        return hopWeight;
    }

    public void setHopWeight(double hopWeight) {
        this.hopWeight = hopWeight;
    }
}
