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

import java.util.Objects;

import org.opennms.oce.datasource.opennms.proto.InventoryModelProtos;
import org.opennms.oce.datasource.opennms.proto.OpennmsModelProtos;

public class EnrichedAlarm {

    /**
     * The source alarm.
     */
    private final OpennmsModelProtos.Alarm alarm;

    /**
     * Inventory generated by the alarm.
     */
    private final InventoryModelProtos.InventoryObjects inventory;

    /**
     * MO type with which the alarm should be associated.
     */
    private final String managedObjectType;

    /**
     * MO instance with which the alarm should be associated.
     */
    private final String managedObjectInstance;

    public EnrichedAlarm(OpennmsModelProtos.Alarm alarm,
                         InventoryModelProtos.InventoryObjects inventory,
                         String managedObjectType,
                         String managedObjectInstance) {
        this.alarm = Objects.requireNonNull(alarm);
        this.inventory = Objects.requireNonNull(inventory);
        this.managedObjectType = Objects.requireNonNull(managedObjectType);
        this.managedObjectInstance = Objects.requireNonNull(managedObjectInstance);
    }

    public OpennmsModelProtos.Alarm getAlarm() {
        return alarm;
    }

    public InventoryModelProtos.InventoryObjects getInventory() {
        return inventory;
    }

    public String getManagedObjectType() {
        return managedObjectType;
    }

    public String getManagedObjectInstance() {
        return managedObjectInstance;
    }
}