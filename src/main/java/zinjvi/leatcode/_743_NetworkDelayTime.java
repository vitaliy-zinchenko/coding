package zinjvi.leatcode;

import java.util.*;

public class _743_NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for (int[] fields : times) {
            int from = fields[0];
            int to = fields[1];
            int time = fields[2];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new Edge(to, time));
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> heap = new PriorityQueue<>();
        int result = 0;

        heap.offer(new Node(K, 0));

        while (!heap.isEmpty()) {
            Node node = heap.poll();

            if (visited.contains(node.node)) continue;
            visited.add(node.node);

            result = node.time;

            if(graph.containsKey(node.node)) {
                for (Edge edge : graph.get(node.node)) {
                    int nextTime = node.time + edge.time;
                    heap.offer(new Node(edge.to, nextTime));
                }
            }
        }

        return N == visited.size() ? result : -1;
    }

    static class Edge {
        public int to;
        public int time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static class Node implements Comparable<Node> {
        public int node;
        public int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(time, o.time);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int nodesCount = 4;
        int start = 2;
        int result = new _743_NetworkDelayTime()
                .networkDelayTime(edges, nodesCount, start);

        System.out.println(">> " + result);
    }

}
