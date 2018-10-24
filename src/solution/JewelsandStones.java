package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/12 11:41
 **/
public class JewelsandStones {

	public int numJewelsInStones(String J, String S) {
		int num = 0;

		for (int i = 0; i < S.length(); i++) {
			if (J.indexOf(S.charAt(i)) != -1) {
				num++;
			}
		}
		return num;
	}

	@Test
	public void test() {

	}
}
