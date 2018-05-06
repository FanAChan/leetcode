package solution;

/**
 * @author Achan
 * @date 2018/5/6 10:06
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 **/
public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {


		if (m <= 0) {
			System.arraycopy(nums2, 0, nums1, 0, n);
			return;
		}
		if (n <= 0) {
			return;
		}
		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[m + n + 1] = nums1[m];
				m--;
			} else {
				nums1[m + n + 1] = nums2[n];
				n--;
			}
		}
		while (n >= 0) {
			nums1[n] = nums2[n];
			n--;
		}
		for (int i = 0; i < nums1.length; i++) {
			int i1 = nums1[i];
			System.out.println(i1);
		}
	}

	public static void main(String[] args) {
		merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
	}
}
