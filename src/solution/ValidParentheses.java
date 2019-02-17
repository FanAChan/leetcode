package solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Achan
 * @date 2018/10/25 14:49
 **/
public class ValidParentheses {
	public boolean isValid(String s) {

		if(s == null || s.length() == 0){
			return false;
		}
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (stack.isEmpty()) {
				if (map.get(c) != null) {
					stack.push(c);
				} else {
					return false;
				}
			} else {
				if (map.get(c) != null) {
					stack.push(c);
				} else if (map.get(stack.peek()).equals(c)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}


	@Test
	public void test() {
		isValid("(]");

	}
}
