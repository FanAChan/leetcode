package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/26 12:04
 **/
public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if (null == needle || "".equals(needle)) {
			return 0;
		}
		int hl = haystack.length();
		int nl = needle.length();
		int i = 0;
		for (; i < hl - nl; i++) {
			int j = 0;
			while (j < nl && haystack.charAt(i + j) == needle.charAt(j)) {
				j++;
			}
			if (j == nl) {
				return i;
			}
		}
		return -1;
	}

	@Test
	public void test() {

	}
}
