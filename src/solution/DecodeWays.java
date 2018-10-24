package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/9 15:02
 **/
public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null || s.length() == 1) {
			return 0;
		}
		int len = s.length();
		if (len == 1) {
			return 1;
		}
		int[] results = new int[len + 1];
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '1') {
				results[i] = results[i - 1] + 1;
			}
			if (s.charAt(i - 1) == '1') {
				results[i] += results[i - 2];
			} else if (s.charAt(i - 1) == '2' && results[i - 1] < '7') {
				results[i] += results[i - 2];
			}
		}

		return 0;
	}

	@Test
	public void test() {

	}
}
