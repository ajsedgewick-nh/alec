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

package org.opennms.oce.features.graph.shell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.Test;
import org.opennms.oce.datasource.api.Alarm;
import org.opennms.oce.datasource.api.InventoryObject;
import org.opennms.oce.datasource.api.InventoryObjectPeerRef;
import org.opennms.oce.datasource.api.InventoryObjectRelativeRef;
import org.opennms.oce.datasource.common.AlarmBean;
import org.opennms.oce.features.graph.api.Edge;
import org.opennms.oce.features.graph.api.Vertex;
import org.opennms.oce.features.graph.graphml.GraphML;
import org.opennms.oce.features.graph.graphml.GraphMLGraph;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

public class GraphMLConversionTest {

    @Test
    public void canConvertGraph() {
        // Build a simple graph:
        // v1 <--(e1)--> v2 <--(e2)--> v3
        Graph<MyVertex,MyEdge> graph = new SparseMultigraph<>();
        MyVertex v1 = new MyVertex("v1");
        MyVertex v2 = new MyVertex("v2");
        MyVertex v3 = new MyVertex("v3");
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        MyEdge e1 = new MyEdge("e1");
        MyEdge e2 = new MyEdge("e2");
        graph.addEdge(e1, v1, v2);
        graph.addEdge(e2, v2, v3);

        GraphML graphML = GraphMLConverter.toGraphML(graph);

        assertThat(graphML.getGraphs(), hasSize(1));
        GraphMLGraph graphMLGraph = graphML.getGraphs().get(0);
        assertThat(graphMLGraph.getNodes(), hasSize(3));
        assertThat(graphMLGraph.getEdges(), hasSize(2));
    }

    @Test
    public void canConvertGraphWithAlarms() {
        Graph<MyVertex,MyEdge> graph = new SparseMultigraph<>();
        MyVertex v1 = new MyVertex("v1");
        graph.addVertex(v1);

        AlarmBean a1 = new AlarmBean();
        a1.setId("a1");
        v1.getAlarms().add(a1);

        AlarmBean a2 = new AlarmBean();
        a2.setId("a2");
        v1.getAlarms().add(a2);

        GraphML graphML = GraphMLConverter.toGraphML(graph);

        assertThat(graphML.getGraphs(), hasSize(1));
        GraphMLGraph graphMLGraph = graphML.getGraphs().get(0);
        assertThat(graphMLGraph.getNodes(), hasSize(3));
        assertThat(graphMLGraph.getEdges(), hasSize(2));
    }

    private static class MyVertex implements Vertex {
        private final String id;
        private List<Alarm> alarms = new ArrayList<>();

        MyVertex(String id) {
            this.id = Objects.requireNonNull(id);
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public List<Alarm> getAlarms() {
            return alarms;
        }

        public void setAlarms(List<Alarm> alarms) {
            this.alarms = alarms;
        }

        @Override
        public Optional<InventoryObject> getInventoryObject() {
            return Optional.empty();
        }
    }

    private static class MyEdge implements Edge {
        private final String id;

        MyEdge(String id) {
            this.id = Objects.requireNonNull(id);
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public Optional<InventoryObjectPeerRef> getInventoryObjectPeerRef() {
            return Optional.empty();
        }

        @Override
        public Optional<InventoryObjectRelativeRef> getInventoryObjectRelativeRef() {
            return Optional.empty();
        }
    }

}