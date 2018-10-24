package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/19 16:20
 **/
public class SmallestRangeI {

	public int smallestRangeI(int[] A, int K) {

		if(null == A || A.length == 0){
			return 0;
		}

		int max = A[0];
		int min = A[0];
		for (int i : A) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		int result = max - min;
		if (result <= 2 * K) {
			return 0;
		} else {
			return result - 2 * K;
		}

	}

	@Test
	public void test() {

	}
}
