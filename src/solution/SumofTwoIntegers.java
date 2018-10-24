package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/11 14:21
 **/
public class SumofTwoIntegers {

	public int getSum(int a, int b) {


		int c = 0;
		while (b != 0) {
			c = a ^ b;
			b = (a & b) << 1;
			a = c;
		}
		return a;
	}

	@Test
	public void test() {

	}
}
