package solution;

/**
 * @author Achan
 * @date 2018/5/4 14:43
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 * Binary Search
 **/
public class Sqrt {

	public int mySqrt(int x) {
		int l = 1;
		int r = x;
		int mid = 0;
		while (true) {
			mid = l + (r - l) / 2;
			if (mid > x / mid) {
				r = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1)) {
					return mid;
				}
				l = mid + 1;
			}
		}
	}

}
