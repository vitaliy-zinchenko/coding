//package zinjvi;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class UndirectedGraph_FindCycle {
//    public static void main(String[] args) {
//
//    }
//    public static class DirectedGraph {
//        private Map<Integer, List<Integer>> adj = new HashMap<>();
//
//        public void addEdge(Integer node1, Integer node2) {
//            getAdjList(node1).add(node2);
//            getAdjList(node2).add(node1);
//        }
//
//        private List<Integer> getAdjList(Integer node) {
//            if(!this.adj.containsKey(node))
//                this.adj.put(node, new LinkedList<Integer>());
//            return this.adj.get(node);
//        }
//
//        public Boolean hasCycle() {
//
//        }
//
//        private
//    }
//
//
//}
