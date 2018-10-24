package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/3 21:53
 **/
public class NumberComplement {

	public int findComplement(int num) {

		int result = 0;
		int n = 1;
		do {
			int temp = 1 - num & 1;
			result += n * temp;
			num >>= 1;
			n <<= 1;

		} while (num > 0);
		return result;
	}

	@Test
	public void test(){

		System.out.println(findComplement(0));
		System.out.println(findComplement(5));
	}
}
