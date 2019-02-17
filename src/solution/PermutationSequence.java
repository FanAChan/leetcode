package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/11/4 13:07
 **/
public class PermutationSequence {

	public String getPermutation(int n, int k) {


		return "";
	}

	public StringBuilder getSubPermutation(int n, int k) {
		return new StringBuilder();
	}

	public int n(int n) {
		int result = 1;
		for (int i = 1; i < n; i++) {
			result *= i;
		}
		return result;
	}

	@Test
	public void test() {

	}
}
