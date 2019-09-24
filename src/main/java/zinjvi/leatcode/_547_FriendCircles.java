package zinjvi.leatcode;

public class _547_FriendCircles {

    /**
     * 1 1 0
     * 1 1 0
     * 0 0 1
     */
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    static class UF {
        private int[] parents;
        private int[] ranks;
        private int count;

        public UF(int size) {
            this.parents = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            this.ranks = new int[size];
            this.count = size;
        }

        private int find(int n1) {
            if (parents[n1] == n1) {
                return n1;
            } else {
                return parents[n1] = find(parents[n1]);
            }
        }

        private void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) return;

            if (ranks[p1] > ranks[p2]) {
                parents[p2] = p1;
            } else if (ranks[p1] < ranks[p2]) {
                parents[p1] = p2;
            } else {
                parents[p2] = p1;
                ranks[p1]++;
            }

            count--;
        }

        private int count() {
            return count;
        }
    }


    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(new _547_FriendCircles().findCircleNum(M));
    }
}

