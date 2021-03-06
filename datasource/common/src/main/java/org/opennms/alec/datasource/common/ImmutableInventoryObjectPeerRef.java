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

package org.opennms.alec.datasource.common;

import static org.opennms.alec.datasource.api.InventoryObject.DEFAULT_WEIGHT;

import java.util.Objects;

import org.opennms.alec.datasource.api.InventoryObjectPeerEndpoint;
import org.opennms.alec.datasource.api.InventoryObjectPeerRef;

/**
 * An implementation of {@link InventoryObjectPeerRef} that enforces deep immutability.
 */
public final class ImmutableInventoryObjectPeerRef implements InventoryObjectPeerRef {
    private final String type;
    private final String id;
    private final InventoryObjectPeerEndpoint endpoint;
    private final long weight;

    private ImmutableInventoryObjectPeerRef(Builder builder) {
        this.type = builder.type;
        this.id = builder.id;
        this.endpoint = builder.endpoint;
        this.weight = builder.weight;
    }

    public static final class Builder {
        private String type;
        private String id;
        private InventoryObjectPeerEndpoint endpoint;
        private long weight;

        private Builder() {
            weight = DEFAULT_WEIGHT;
        }

        private Builder(InventoryObjectPeerRef inventoryObjectPeerRef) {
            this.type = inventoryObjectPeerRef.getType();
            this.id = inventoryObjectPeerRef.getId();
            this.endpoint = inventoryObjectPeerRef.getEndpoint();
            this.weight = inventoryObjectPeerRef.getWeight();
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setEndpoint(InventoryObjectPeerEndpoint endpoint) {
            this.endpoint = endpoint;
            return this;
        }

        public Builder setWeight(long weight) {
            this.weight = weight;
            return this;
        }

        public ImmutableInventoryObjectPeerRef build() {
            Objects.requireNonNull(id, "Id cannot be null");
            Objects.requireNonNull(type, "Type cannot be null");

            return new ImmutableInventoryObjectPeerRef(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilderFrom(InventoryObjectPeerRef inventoryObjectPeerRef) {
        return new Builder(inventoryObjectPeerRef);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public InventoryObjectPeerEndpoint getEndpoint() {
        return endpoint;
    }

    @Override
    public long getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableInventoryObjectPeerRef that = (ImmutableInventoryObjectPeerRef) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(id, that.id) &&
                endpoint == that.endpoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, endpoint);
    }

    @Override
    public String toString() {
        return "ImmutableInventoryObjectPeerRef{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", endpoint=" + endpoint +
                ", weight=" + weight +
                '}';
    }
}
