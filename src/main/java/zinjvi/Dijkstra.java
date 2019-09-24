package zinjvi;

import java.util.*;

public class Dijkstra {

    private Map<Integer, Integer> distance = new HashMap<>();
    private Map<Integer, Integer> previous = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private PriorityQueue<Node> heap = new PriorityQueue<>();

    public void dijkstra(DirectedGraph graph, Integer source) {
        distance.put(source, 0);
        heap.add(new Node(source, 0));

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if(visited.contains(node.node)) continue;

            visited.add(node.node);

            for (DirectedGraph.Edge edge : graph.getAdj(node.getNode())) {
                if(visited.contains(edge.to)) continue;
                Integer distanceToChild = distance.getOrDefault(edge.to, Integer.MAX_VALUE);
                Integer newDistanceToChild = node.distance + edge.weight;
                if (newDistanceToChild < distanceToChild) {
                    heap.offer(new Node(edge.to, newDistanceToChild));
                    previous.put(edge.to, node.node);
                    distance.put(edge.to, newDistanceToChild);
                }
            }
        }
    }

    public List<Integer> pathToDestination(Integer destination) {
        List<Integer> path = new ArrayList<Integer>();
        for(Integer node = destination; node != null; node = previous.get(node)) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public Integer distanceToDestination(Integer destination) {
        return distance.get(destination);
    }

    private class Node implements Comparable {
        private Integer node;
        private Integer distance;

        public Node(Integer node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }

        public Integer getNode() {
            return node;
        }

        public Integer getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(distance, ((Node) o).distance);
        }
    }

    public static class DirectedGraph {

        private Map<Integer, List<Edge>> adj = new HashMap<>();

        public void addEdge(Integer n1, Integer n2, Integer weight) {
            if (!adj.containsKey(n1)) {
                adj.put(n1, new LinkedList<Edge>());
            }
            adj.get(n1).add(new Edge(n2, weight));
        }

        public List<Edge> getAdj(Integer node) {
            return adj.get(node);
        }

        public class Edge {
            private Integer to;
            private Integer weight;

            public Edge(Integer to, Integer weight) {
                this.to = to;
                this.weight = weight;
            }

            public Integer getTo() {
                return to;
            }

            public Integer getWeight() {
                return weight;
            }
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();

        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 4, 6);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 1, 1);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 1);

        System.out.println(dijkstra.distanceToDestination(4));
        System.out.println(dijkstra.pathToDestination(4));
    }


}
