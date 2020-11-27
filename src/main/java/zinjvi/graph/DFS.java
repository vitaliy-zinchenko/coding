package zinjvi.graph;

import java.util.*;

public class DFS {

    /* ****  Can Be copied  **** */
    static class Graph {
        private int v;
        private LinkedList<Integer> adj[];

        public Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                this.adj[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        /* **** ^ Can Be copied ^ **** */

        public List<Integer> dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            List<Integer> result = new LinkedList<>();
            Stack<Integer> toVisit = new Stack<>();

            toVisit.add(start);

            while (!toVisit.isEmpty()) {
                Integer current = toVisit.pop();

                visited.add(current);
                result.add(current);
                for (Integer child: adj[current]) {
                    if (!visited.contains(child)) {
                        toVisit.add(child);
                    }
                }
            }
            return result;
        }
    }

    // ToVisit:
    // Visited: 2 3 0 1
    // Result:  2 3 0 1

    // Start: 2
    // Adj:
    //   0 -> 1, 2
    //   1 -> 2
    //   2 -> 0, 3
    //   3 -> 3

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 0);
        g.addEdge(3, 3);

        System.out.println(g.dfs(2).toString());
    }

}
