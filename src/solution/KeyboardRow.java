package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Achan
 * @date 2018/6/30 14:31
 **/
public class KeyboardRow {

	public String[] findWords(String[] words) {

		HashMap<Character, Integer> charToRow = new HashMap(26);
		ArrayList<String> resultList = new ArrayList<>();
		String firstRow = "qwertyuiop";
		String secondRow = "asdfghjkl";
		String thirdRow = "zxcvbnm";

		for (char c : firstRow.toCharArray()) {
			charToRow.put(c,1);
		}
		for (char c : secondRow.toCharArray()) {
			charToRow.put(c,2);
		}
		for (char c : thirdRow.toCharArray()) {
			charToRow.put(c,3);
		}

		for (String word : words) {
			int row = 0;
			boolean bool = true;
			for (Character character : word.toCharArray()) {
				if(row == 0){
					row = charToRow.get(Character.toLowerCase(character));
				}else if(row != charToRow.get(character)){
					bool = false;
					break;
				}
			}
			if(bool){
				resultList.add(word);
			}
		}

		return resultList.toArray(new String[resultList.size()]);

	}


	/**
	 * 使用正则表达式
	 * @param words
	 * @return
	 */
	public String[] findWords2(String[] words) {

		ArrayList<String> resultList = new ArrayList<>();
		for (String word : words) {
			if(word.toLowerCase().matches("[qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+")){
				System.out.println(word);
				resultList.add(word);
			}
		}
		return resultList.toArray(new String[resultList.size()]);
	}

	@Test
	public void test(){
		System.out.println(findWords2(new String[]{"Hello", "Alaska", "Dad", "Peace"}));

	}
}
