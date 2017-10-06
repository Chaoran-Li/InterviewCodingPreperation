package com.chaoran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoranli on 10/6/17.
 */
public class DeepCopyUndirectedGraph {

    public List<GraphNode> copy(List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }

        List<GraphNode> copyGraph = new ArrayList<>();
        Map<GraphNode, GraphNode> lookup = new HashMap<>();

        for (int i = 0; i < graph.size(); i++) {
            GraphNode cur = graph.get(i);
            if (!lookup.containsKey(cur)) {
                lookup.put(cur, new GraphNode(cur.key));
            }
            GraphNode copyNode = lookup.get(cur);
            copyGraph.add(copyNode);

            for (int j = 0; j < cur.neighbors.size(); j++) {
                GraphNode curNeighbor = cur.neighbors.get(j);
                if (!lookup.containsKey(curNeighbor)) {
                    lookup.put(curNeighbor, new GraphNode(curNeighbor.key));
                }
                copyNode.neighbors.add(lookup.get(curNeighbor));
            }
        }
        return copyGraph;
    }
}
