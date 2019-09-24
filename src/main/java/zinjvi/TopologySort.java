package zinjvi;

import java.util.*;

public class TopologySort {

    public static void main(String[] args) {
        Integer[][] edges = {
                {2, 4},
                {3, 2},
                {1, 2},
                {5, 3},
                {5, 4},
                {0, 2}
        };

        Integer[] result = sort(edges);

        for (Integer node: result) {
            System.out.println(node);
        }
    }

    public static Integer[] sort(Integer[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (Integer[] relation: edges) {
            Integer from = relation[0];
            Integer to = relation[1];

            if(!graph.containsKey(from)) {
                graph.put(from, new LinkedList<Integer>());
            }

            graph.get(from).add(to);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            Integer node = entry.getKey();
            sort(node, visited, stack, graph);
        }

        return stack.toArray(new Integer[stack.size()]);
    }

    private static void sort(Integer node, Set<Integer> visited, Stack<Integer> stack, Map<Integer, List<Integer>> graph) {
        if(visited.contains(node)) {
            return;
        }

        visited.add(node);

        List<Integer> subNodes = graph.get(node);
        if(subNodes != null) {
            for (Integer subNode : subNodes) {
                sort(subNode, visited, stack, graph);
            }
        }

        stack.add(node);
    }

}
