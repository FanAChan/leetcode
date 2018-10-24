package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/24 13:39
 **/
public class ReverseInteger {


	public int reverse(int x) {
		int result = 0;
		while (x != 0){
			int num = x % 10;
			x /= 10;
			int temp = result;
			result = result * 10 + num;
			if((result - num) / 10 == temp){
				result = 0;
				break;
			}
		}
		return result;
	}


	@Test
	public void test() {

	}
}
