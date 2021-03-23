package solution;

public class MaxValue {
    public int maxValue(int[][] grid) {
        int[][] temp = new int[grid.length + 1][grid[0].length + 1];

        temp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp[i + 1][j + 1] = Math.max(temp[i][j+1],temp[i + 1][j]) + grid[i][j];
            }
        }

        return temp[grid.length][grid[0].length];
    }
}
