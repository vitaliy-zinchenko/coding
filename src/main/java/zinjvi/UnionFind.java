package zinjvi;

import java.util.Arrays;

public class UnionFind {
    public static void main(String[] args) {
        UF uf = new UF(5);

        uf.print();

        uf.union(0, 1);
        uf.print();

        uf.union(1, 2);
        uf.print();
    }

    static class UF {

        private int[] arr;

        private int components;

        public void print() {
            System.out.println(components + "  >>  " + Arrays.asList(arr));
        }

        public UF(int count) {
            this.arr = new int[count];
            for (int i = 0; i < count; i++) {
                this.arr[i] = i;
            }
            components = count;
        }

        public void union(int first, int second) {
            int firstRoot = find(this.arr[first]);
            int secondRoot = find(this.arr[second]);

            if (firstRoot ==secondRoot) return;

            this.arr[firstRoot] = secondRoot;
            this.components -= 1;
        }

        public Boolean connected(int first, int second) {
            return find(first) == find(second);
        }

        private int find(int node) {
            int root = node;
            while (this.arr[root] != root) {
                root = this.arr[root];
            }

            while (root != node) {
                int r = this.arr[node];
                this.arr[node] = root;
                node = r;
            }

            return root;
        }
    }
}
