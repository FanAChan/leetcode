package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/24 14:21
 **/
public class PalindromeNumber {

	public boolean isPalindrome(int x) {


		if (x < 0) {
			return false;
		}
		int temp = x;
		int result = 0;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		if (temp == result) {
			return true;
		}
		return false;

	}


	@Test
	public void test() {

	}
}
