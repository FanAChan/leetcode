package solution;

/**
 * @author Achan
 * @date 2018/5/4 13:01Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 **/
public class AddBinary {

	public static String addBinary(String a, String b) {

		if (a == null || b == null) {
			return a + b;
		}


		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;

		}
		int alen = a.length();
		int blen = b.length();
		char[] ac = a.toCharArray();
		char temp = '0';
		int i = 1;
		for (; i <= blen; i++) {
			if (a.charAt(alen - i) == '1' && b.charAt(blen - i) == '1') {
				ac[alen - i] = temp;
				temp = '1';
			} else if (a.charAt(alen - i) == '1' || b.charAt(blen - i) == '1') {
				if (temp == '1') {
					ac[alen - i] = '0';
				} else {
					ac[alen - i] = '1';
					temp = '0';
				}
			} else {
				ac[alen - i] = temp;
				temp = '0';
			}
		}
		for (; i <= alen; i++) {
			if (temp == '0') {
				break;
			} else if (ac[alen - i] == '1') {
				ac[alen - i] = '0';
			} else {
				ac[alen - i] = '1';
				temp = '0';
				break;
			}
		}

		if (temp == '1') {
			return "1" + String.valueOf(ac);
		} else {
			return String.valueOf(ac);
		}


	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1010", "1011"));
	}
}
