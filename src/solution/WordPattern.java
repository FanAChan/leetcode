package solution;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Achan
 * @date 2018/10/19 15:58
 **/
public class WordPattern {

	public boolean wordPattern(String pattern, String str) {


		String[] ss = str.split(" ");
		char[] chars = pattern.toCharArray();
		HashMap<Character, String> map = new HashMap<>();

		if(ss.length != chars.length){
			return false;
		}
		int i = 0;
		for (char c : chars) {
			String s = map.get(c);
			if(null == s && !map.containsValue(ss[i])){
				map.put(c,ss[i]);
				i++;
			} else if(ss[i].equals(s)){
				i++;
			} else {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
wordPattern("abba","dog cat cat dog");
	}
}
