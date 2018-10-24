package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/9/17 13:43
 **/
public class PowerofThree {

	public boolean isPowerOfThree(int n) {
		if(n <= 0){
			return false;
		}
		while (n % 3 == 0 && n != 0){
			n /= 3;
		}
		return n == 1;
	}

	@Test
	public void test(){
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(6));
		System.out.println(isPowerOfThree(27));
	}
}
