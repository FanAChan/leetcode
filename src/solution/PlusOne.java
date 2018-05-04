package solution;

/**
 * @author Achan
 * @date 2018/5/4 11:58
 * <p>
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 **/
public class PlusOne {

	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[0];
		}

		int len = digits.length;
		int i = len - 1;
		for (; i >= 0; i--) {
			int digit = digits[i];
			if (digit == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				break;
			}
		}
		if (i == -1) {
			int[] res = new int[len + 1];
			res[0] = 1;
			System.arraycopy(digits, 0, res, 1, len);
			return res;
//			int[] res = new int[len + 1];//数组初始化默认值为1
//			res[0] = 1;
//			return res;

		} else {
			return digits;
		}
	}

	public static void main(String[] args) {
		int[] res = plusOne(new int[]{1, 2, 3});
		for (int i = 0; i < res.length; i++) {
			int re = res[i];
			System.out.print(re);

		}
	}
}
