package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/28 15:48
 **/
public class CountAndSay {

	public String countAndSay(int n) {
		StringBuilder temp = new StringBuilder("1");
		for (int j = 1; j < n; j++) {
			temp = count(temp.toString());
		}
		return temp.toString();

	}

	public StringBuilder count(String s) {
		StringBuilder result = new StringBuilder();
		char[] chars = s.toCharArray();
		char a = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == a) {
				count++;
			} else {
				result.append(count);
				result.append(a);
				a = chars[i];
				count = 1;
			}
		}
		result.append(count);
		result.append(a);
		return result;
	}

	@Test
	public void test() {
		countAndSay(5);
	}
}
