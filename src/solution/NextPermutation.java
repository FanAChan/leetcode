package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/26 15:27
 **/
public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int len = nums.length;
		int i = len - 2;
		for (; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				break;
			}
		}
		if (i >= 0) {
			int j = len - 1;
			while (j > i && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}

	public void reverse(int[] nums, int start) {
		int j = nums.length - 1;

		while (j > start) {
			swap(nums, j, start);
			j--;
			start++;
		}
	}

	@Test
	public void test() {
//		nextPermutation(new int[]{1, 2, 3});
//		nextPermutation(new int[]{3, 2, 1});
		nextPermutation(new int[]{1,5, 1});
	}
}
