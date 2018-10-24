package solution;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Achan
 * @date 2018/10/15 10:20
 **/
public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 == null || s2 == null) {
			return false;
		}
		int len1 = s1.length();
		int len2 = s2.length();
		ArrayList<Integer> indexList = new ArrayList<>();


		return false;
	}


	@Test
	public void test() {

	}
}
