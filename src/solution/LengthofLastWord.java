package solution;

/**
 * @author Achan
 * @date 2018/5/4 11:15
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 **/
public class LengthofLastWord {

	public static int lengthOfLastWord(String s) {
		if(s == null || s.length()==0){
			return 0;
		}
		int len = s.length();
		int i = len;
		for(i-=1;i>0;i-- ){
			if(s.charAt(i) != ' '){
				break;
			}
		}
		len = i;
		for(;i>=0;i-- ){
			if(s.charAt(i) == ' '){
				break;
			}
		}
		return len-i;

	}

	public static void main(String[] args) {
		int res = LengthofLastWord.lengthOfLastWord("hello world");
		System.out.println(res);
		int res2 = LengthofLastWord.lengthOfLastWord(" ");
		System.out.println(res2);
	}
}
