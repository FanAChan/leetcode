package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/11/4 11:44
 **/
public class Pow {

	public double myPow(double x, int n) {
		if (x == 0 || x == 1) {
			return x;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if(n == -1){
			return  1/x;
		}
		double temp = myPow(x, n >> 1);
		temp *= temp;
		if ((n & 1) == 1) {
			temp *= x;
		}
		return temp;
	}

	public double powUnsigned(double x, int n) {

		double temp = powUnsigned(x, n >> 1);
		temp *= temp;
		if ((n & 1) == 1) {
			temp *= x;
		}
		return temp;
	}

	@Test
	public void test() {

	}
}
