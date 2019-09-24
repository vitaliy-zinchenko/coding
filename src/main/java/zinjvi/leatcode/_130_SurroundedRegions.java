package zinjvi.leatcode;

import java.util.Arrays;

public class _130_SurroundedRegions {

    public static final char O = 'O';
    public static final char X = 'X';

    public void solve(char[][] board) {
        if (board.length == 0)
            return;

        int rows = board.length;
        int columns = board[0].length;

        UF uf = new UF(rows * columns + 1);

        int borderRootIndex = rows * columns;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (board[r][c] != O) {
                    continue;
                }
                int currentIndex = r * columns + c;
                if (isBorder(rows, columns, r, c)) {
                    uf.union(currentIndex, borderRootIndex);
                } else {
                    if (board[r - 1][c] == O) uf.union(currentIndex, (r - 1) * columns + c);
                    if (board[r + 1][c] == O) uf.union(currentIndex, (r + 1) * columns + c);
                    if (board[r][c - 1] == O) uf.union(currentIndex, r * columns + (c - 1));
                    if (board[r][c + 1] == O) uf.union(currentIndex, r * columns + (c + 1));
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int currentIndex = r * columns + c;
                if (!uf.connected(currentIndex, borderRootIndex)) {
                    board[r][c] = X;
                }
            }
        }
    }

    private boolean isBorder(int rows, int columns, int r, int c) {
        return r == 0 || r == rows - 1 || c == 0 || c == columns - 1;
    }

    static class UF {

        private Integer[] arr;

        public void print() {
            System.out.println(Arrays.asList(arr));
        }

        public UF(Integer count) {
            this.arr = new Integer[count];
            for (int i = 0; i < count; i++) {
                this.arr[i] = i;
            }
        }

        public void union(Integer first, Integer second) {
            Integer firstRoot = find(this.arr[first]);
            Integer secondRoot = find(this.arr[second]);

            if (firstRoot.equals(secondRoot)) return;

            this.arr[firstRoot] = secondRoot;
        }

        public Boolean connected(Integer first, Integer second) {
            return find(first).equals(find(second));
        }

        private Integer find(Integer node) {
            Integer root = node;
            while (!this.arr[root].equals(root)) {
                root = this.arr[root];
            }

            while (!root.equals(node)) {
                Integer r = this.arr[node];
                this.arr[node] = root;
                node = r;
            }

            return root;
        }
    }


    public static void main(String[] args) {
        char[][] board = {
                {X, X, X},
                {X, O, X},
                {X, O, X},
                {O, X, X}
        };

//        char[][] board = {
//                {O, O, O},
//                {O, O, O},
//                {O, O, O}
//        };

        print(board);

        new _130_SurroundedRegions().solve(board);

        print(board);
    }

    private static void print(char[][] board) {
        System.out.println("[-----------]");
        for (char[] row : board) {
            System.out.print("  ");
            for (char c : row) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
        System.out.println("[-----------]");
    }
}
