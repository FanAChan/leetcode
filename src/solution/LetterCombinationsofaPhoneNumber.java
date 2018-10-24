package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2018/10/11 20:19
 **/
public class LetterCombinationsofaPhoneNumber {


	public List<String> letterCombinations(String digits) {


		if (digits == null || "".equals(digits)) {
			return new ArrayList<>();
		}
		List<StringBuilder> resultSB = new ArrayList<>();
		List<String> result = new ArrayList<>();

		char[][] letters = {{'a', 'b', 'c'},
				{'d', 'e', 'f'},
				{'g', 'h', 'i'},
				{'j', 'k', 'l'},
				{'m', 'n', 'o'},
				{'p', 'q', 'r', 's'},
				{'t', 'u', 'v'},
				{'w', 'x', 'y', 'z'}};
		resultSB = combineCharAtI(digits, letters, resultSB, 0);

		for (StringBuilder stringBuilder : resultSB) {
			result.add(stringBuilder.toString());
		}
		return result;
	}

	public List<StringBuilder> combineCharAtI(String digits, char[][] letters, List<StringBuilder> results, int i) {
		if (i == digits.length()) {
			return results;
		}
		List<StringBuilder> temp = new ArrayList<>();
		int c = digits.charAt(i) - '0' - 2;
		for (int j = 0; j < letters[c].length; j++) {
			char letter = letters[c][j];
			if (results.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				sb.append(letter);
				temp.add(sb);
			} else {
				for (StringBuilder result : results) {
					StringBuilder sb = new StringBuilder(result);
					sb.append(letter);
					temp.add(sb);
				}
			}
		}
		return combineCharAtI(digits, letters, temp, i + 1);
	}


	@Test
	public void test() {

		letterCombinations("23");
	}
}
