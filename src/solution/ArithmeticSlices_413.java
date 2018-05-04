package solution;

/**
 * @author Achan
 * @date 2018/5/1 21:33
 * <p>
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * <p>
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 **/
public class ArithmeticSlices_413 {

	public static int numberOfArithmeticSlices(int[] A) {

		if (A == null || A.length < 3) {
			return 0;
		}

		int res = 0;
		int curr = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				curr += 1;
				res += curr;
			} else {
				curr = 0;
			}

		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		ArithmeticSlices_413.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});
	}
}
