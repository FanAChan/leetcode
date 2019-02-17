package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/11/1 13:42
 **/
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0){
			return "";
		}

		int len = s.length();
		int[] result = new int[2];
		int maxLen = 1;
		int[][] temp = new int[len][len];
		for (int i = 0; i < len; i++) {
			temp[i][i] = 1;
			if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
				temp[i][i + 1] = 1;
				result[0] = i;
				result[1] = i + 1;
			}
		}
		for (int i = 2; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (s.charAt(j) == s.charAt(j + i)) {
					temp[j][j + i] = temp[j + 1][j + i - 1];
					if (temp[j][j + i] == 1 && i > maxLen) {
						maxLen = i;
						result[0] = j;
						result[1] = j + i;
					}
				}
			}
		}
		return s.substring(result[0], result[1] + 1);

	}

	@Test
	public void test() {
		longestPalindrome("cbbd");
	}
}
