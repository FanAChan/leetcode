package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/6/30 22:57
 **/
public class ReshapetheMatrix {

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums == null) {
			return null;
		}
		int row = nums.length;
		int col = nums[0].length;
		if (r * c != col * row) {
			return nums;
		}
		int[][] result = new int[r][c];
		int curRow = 0;
		int curCol = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				result[curRow][curCol++] = nums[i][j];
				if (curCol == c) {
					curCol = 0;
					curRow++;
				}
			}
		}
		return result;
	}

	@Test
	public void test() {
		matrixReshape(new int[][]{{1,2},{3,4}},1,4);
	}

}
