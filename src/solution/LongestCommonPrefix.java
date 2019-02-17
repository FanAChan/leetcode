package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/24 15:28
 **/
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		int len = strs.length;
		int i = 0;
		boolean common = true;
		while (common) {
			char c;
			if(i < strs[0].length()) {
				c = strs[0].charAt(i);
			}else{
				break;
			}
			int j = 1;
			for (; j < len; j++) {
				if (strs[j].length() <= i || strs[j].charAt(i) != c) {
					common = false;
				}
			}
			if (common && j == len) {
				result.append(c);
				i++;
			}
		}
		return result.toString();
	}


	@Test
	public void test() {
		longestCommonPrefix(new String[]{"flower", "flow", "flight"});
	}
}
