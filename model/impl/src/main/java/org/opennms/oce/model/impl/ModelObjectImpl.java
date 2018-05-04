package org.opennms.oce.model.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.opennms.oce.model.api.Group;
import org.opennms.oce.model.api.ModelObject;
import org.opennms.oce.model.api.OperationalState;
import org.opennms.oce.model.api.ServiceState;

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

public class ModelObjectImpl implements ModelObject {
    private String type;
    private String subType;
    private String uniqueId;
    private String friendlyName;
    private ModelObject parent;
    private Map<String, Group> children = new HashMap<>(0);
    private Map<String, Group> peers = new HashMap<>(0);
    private Map<String, Group> nephews = new HashMap<>(0);
    private Map<String, Group> uncles = new HashMap<>(0);
    private OperationalState operationalState = OperationalState.NORMAL;
    private ServiceState serviceState = ServiceState.IN;
    
    public ModelObjectImpl() {
		// TODO Auto-generated constructor stub
	}

    public ModelObjectImpl(String uniqueId, ModelObject parent, String type, String friendlyName) {
        this.uniqueId = uniqueId;
    	this.parent = parent;
    	this.type = type;
    	this.friendlyName = friendlyName;
    	if (type != "model" && parent != null) {
        	// Parent must be null for the Root of the Model
            ((ModelObjectImpl) parent).addChild(this);
    	}
    }
    
    /**
     * non-null
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * nullable
     */
    public String getSubType(){
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    /**
     * non-null
     *
     * A globally unique id
     * @return uuid
     */
    @Override
    public String getId(){
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * nullable
     */
    @Override
    public String getFriendlyName(){
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public ModelObject getParent() {
        return parent;
    }

    public void setParent(ModelObject parent) {
        this.parent = parent;
        if (type != "model") {
            // Parent must be null for the Root of the Model
            ((ModelObjectImpl) parent).addChild(this);
        }
    }

    @Override
    public Set<ModelObject> getChildren() {
        return children.values().stream().map(g -> g.getMembers()).flatMap(x -> x.stream()).collect(Collectors.toSet());
    }

	@Override
	public Set<ModelObject> getPeers() {
        return peers.values().stream().map(g -> g.getMembers()).flatMap(x -> x.stream()).collect(Collectors.toSet());
	}

	@Override
	public Set<ModelObject> getUncles() {
        return uncles.values().stream().map(g -> g.getMembers()).flatMap(x -> x.stream()).collect(Collectors.toSet());
	}

	@Override
	public Set<ModelObject> getNephews() {
        return nephews.values().stream().map(g -> g.getMembers()).flatMap(x -> x.stream()).collect(Collectors.toSet());
	}

	public void addChild(ModelObject child) {
        addMember(child, children);
	}

	public void addPeer(ModelObject child) {
        addMember(child, peers);
	}

	public void addNephew(ModelObject child) {
        addMember(child, nephews);
	}

	public void addUncle(ModelObject child) {
        addMember(child, uncles);
	}

    private void addMember(ModelObject member, Map<String, Group> map) {
        ((GroupImpl) getGroup(map, member.getType())).addMember(member);
    }

    @Override
    public Group getChildGroup(String objectType) {
        return children.get(objectType);
    }

    @Override
    public Group getPeerGroup(String objectType) {
        return peers.get(objectType);
    }

    @Override
    public Group getNephewGroup(String objectType) {
        return nephews.get(objectType);
    }

    @Override
    public Group getUncleGroup(String objectType) {
        return uncles.get(objectType);
    }

	private Group getGroup(Map<String, Group> map, String type) {
		Group g = map.get(type);
		if (g == null) {
			g = new GroupImpl(this);
			map.put(type, g);
		}
		return g;
	}

	@Override
	public String toString() {
		return "MO[" + type + "," + uniqueId + "]";
	}

    @Override
    public OperationalState getOperationalState() {
        return operationalState;
    }

    @Override
    public void setOperationalState(OperationalState state) {
        OperationalState previous = operationalState;
        operationalState = state;
        propagateOperationalStateChange(previous);
    }

    @Override
    public ServiceState getServiceState() {
        return serviceState;
    }

    @Override
    public void setServiceState(ServiceState state) {
        ServiceState previous = serviceState;
        serviceState = state;
        propagateServiceStateChange(previous);
    }

    private void propagateOperationalStateChange(OperationalState previous) {
        parent.getChildGroup(type).updateOperationalState(this, previous);
        updateOperationalState(getPeerGroup(type), previous);
        updateOperationalState(getUncleGroup(type), previous);
    }

    private void propagateServiceStateChange(ServiceState previous) {
        parent.getChildGroup(type).updateServiceState(this, previous);
        updateServiceState(getPeerGroup(type), previous);
        updateServiceState(getUncleGroup(type), previous);
    }

    // Update the Group OpStatus if this ModelObject has a group of that type
    private void updateOperationalState(Group group, OperationalState previous) {
        if (group == null) {
            return;
        }
        group.updateOperationalState(this, previous);
    }

    // Update the Group SvcStatus if this ModelObject has a group of that type
    private void updateServiceState(Group group, ServiceState previous) {
        if (group == null) {
            return;
        }
        group.updateServiceState(this, previous);
    }

}