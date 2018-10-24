package solution;

/**
 * @author Achan
 * @date 2018/9/17 12:07
 **/
public class Numberof1Bits {

	public int hammingWeight(int n) {

		if (n == 0) {
			return 0;
		} else {
			int result = 0;
			for (int i = 0; i < 32; i++) {
				if ((n & 1) == 1) {
					result++;
				}
				n >>= 1;
			}
			return result;
		}
	}
}
