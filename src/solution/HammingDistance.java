package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/11 21:17
 **/
public class HammingDistance {


	public int hammingDistance(int x, int y) {
		int temp = x ^ y;
		int result = 0;
		while (temp > 0) {
			result += temp & 1;
			temp >>= 1;
		}
		System.out.println(result);
		return result;
	}

	@Test
	public void test() {
		hammingDistance(1,4);
	}
}
