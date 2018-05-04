package solution;

/**
 * @author Achan
 * @date 2018/5/4 15:22
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Returns: True
 * <p>
 * Example 2:
 * <p>
 * Input: 14
 * Returns: False
 **/
public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1) {
			return true;
		}
		int l = 0;
		int r = num;
		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (mid == num / mid && num % mid == 0) {
				return true;
			} else {
				if (mid > num / mid) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		ValidPerfectSquare.isPerfectSquare(16);
	}
}
