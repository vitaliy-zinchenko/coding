package zinjvi.graph;

import java.util.*;

public class Dijkstra {

    static class Vertex implements Comparable<Vertex> {
        private Integer node;
        private Integer weight;

        public Vertex(Integer node, Integer weight) {
            this.node = node;
            this.weight = weight;
        }

        public Integer getNode() {
            return node;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight.compareTo(o.weight);
        }
    }

    public static void dijkstra(Integer nodesCount, List<Integer>[] adj, Integer[][] weights, Integer start, Integer dest) {
        Integer[] dist = new Integer[nodesCount];
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Vertex> toVisit = new PriorityQueue<>();

        Integer[] prev = new Integer[nodesCount];

        for (int i = 0; i < nodesCount; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;
        toVisit.add(new Vertex(start, 0));

        while (!toVisit.isEmpty()) {
            Vertex currentVertex = toVisit.poll();

            if (visited.contains(currentVertex.node)) {
                continue;
            }
            visited.add(currentVertex.node);

            for (Integer child: adj[currentVertex.node]) {
                Integer weightBetweenNodes = weights[currentVertex.node][child];
                if (weightBetweenNodes == null) {
                    throw new RuntimeException("No weight for the edge " + currentVertex.node + " -> " + child);
                }
                Integer newChildWeight = dist[currentVertex.node] + weightBetweenNodes;
                if (newChildWeight < dist[child]) {
                    dist[child] = newChildWeight;
                    prev[child] = currentVertex.node;
                    toVisit.add(new Vertex(child, newChildWeight));
                }
            }
        }

        System.out.println("Distance to " + dest + " is " + dist[dest]);
        System.out.print(dest);
        Integer v = dest;
        while(!v.equals(start)) {
            System.out.print("   <--" + weights[prev[v]][v] + "--   ");
            System.out.print(prev[v]);
            v = prev[v];
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        Integer nodesCount = 7;

        LinkedList<Integer>[] adj = new LinkedList[nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            adj[i] = new LinkedList<>();
        }
        adj[0].add(6);
        adj[1].add(2);
        adj[1].add(4);
        adj[1].add(0);
        adj[2].add(3);
        adj[2].add(5);
        adj[3].add(6);
        adj[4].add(2);
        adj[4].add(5);
        adj[5].add(6);

        Integer[][] weights = new Integer[nodesCount][nodesCount];
        weights[0][6] = 2;
        weights[1][2] = 3;
        weights[1][4] = 2;
        weights[1][0] = 6;
        weights[2][3] = 6;
        weights[2][5] = 1;
        weights[3][6] = 1;
        weights[4][2] = 2;
        weights[4][5] = 3;
        weights[5][6] = 4;


        dijkstra(nodesCount, adj, weights, 1, 6);
    }

}
