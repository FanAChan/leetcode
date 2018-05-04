package solution;

/**
 * @author Achan
 * @date 2018/5/4 11:44
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 **/
public class RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {

		if(magazine == null){
			return false;
		}

		if (ransomNote == null ||(magazine.length() < ransomNote.length())){
			return false;
		}

		int[] a = new int[26];

		char[] rc = ransomNote.toCharArray();
		char[] mc = magazine.toCharArray();

		for (int i = 0; i < mc.length; i++) {
			char c = mc[i];
			a[c-'a'] ++;
		}
		for (int i = 0; i < rc.length; i++) {
			char c = rc[i];
			if(a[c-'a'] > 0){
				a[c-'a'] --;
			}else {
				return false;
			}
		}
		return true;
	}

}
