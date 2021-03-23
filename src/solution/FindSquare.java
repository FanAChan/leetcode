package solution;

import org.junit.Test;

public class FindSquare {

    public int[] findSquare(int[][] matrix) {

        int length = matrix.length;

        int size = 1;
        int r = length;
        int c = length;
        boolean[][][] isSquare = new boolean[length][length][length + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 0) {
                    if (i < r) {
                        r = i;
                        c = j;
                    } else if (i == r && c > j) {
                        c = j;
                    }
                    isSquare[i][j][1] = true;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                int temp = Math.max(i, k);
                for (int jsize = 2; jsize < length - temp + 1; jsize++) {
                    if (check(isSquare, i, k, jsize)) {
                        if (size < jsize) {
                            size = jsize;
                            r = i;
                            c = k;
                        } else if (size == jsize) {
                            if (i < r) {
                                r = i;
                                c = k;
                            } else if (i == r && c < k) {
                                c = k;
                            }
                        }
                    }
                }
            }
        }
        if (r != length) {
            return new int[]{r, c, size};
        } else {
            return new int[0];
        }
    }

    private boolean check(boolean[][][] isSquare, int i, int j, int size) {
        if (isSquare[i][j][size - 1] && isSquare[i + size - 1][j + size - 1][1]) {
            int i1 = i + size - 1;
            int j1 = j + size - 1;
            for (int k = 0; k < size; k++) {
                if (!(isSquare[i1][j1 - k][1] && isSquare[i1 - k][j1][1])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Test
    public void test() throws Exception {
        int[][] ints = {{1, 0, 1}, {0, 0, 1}, {0, 0, 1}};
//        int[][] ints = {{0,1,1}, {1, 0, 1}, {1, 1, 0}};
        int[] square = findSquare(ints);
        for (int i : square) {
            System.out.println(i);
        }
    }

}
