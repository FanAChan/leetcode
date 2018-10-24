package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/9/17 11:03
 **/
public class ReverseBits {

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = (result << 1) + (n & 1);
			n >>= 1;
		}
		return result;
	}

	@Test
	public void test() {
		System.out.println(reverseBits(43261596));
	}
}
