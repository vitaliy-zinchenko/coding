package zinjvi.graph;

import java.util.*;

public class BFS {

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

        public List<Integer> bfs(int start) {
            Set<Integer> visited = new HashSet<>();
            LinkedList<Integer> toVisit = new LinkedList<>();
            List<Integer> result = new LinkedList<>();

            toVisit.add(start);

            while (!toVisit.isEmpty()) {
                Integer current = toVisit.poll();
                visited.add(current);
                for (Integer child: adj[current]) {
                    if (visited.contains(child)) {
                        continue;
                    }
                    toVisit.add(child);
                }
                result.add(current);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 0);
        g.addEdge(3, 3);

        System.out.println(g.bfs(2).toString());
        // 2 0 3 1
        // 2 3 0 1
    }





}
