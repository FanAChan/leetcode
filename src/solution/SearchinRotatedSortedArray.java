package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/26 17:55
 **/
public class SearchinRotatedSortedArray {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0){
			return -1;
		}
		int index = searchBiggest(nums);
		if (index == nums.length - 1) {
			if (nums[index] < target || nums[0] > target) {
				return -1;
			}
			return searchTarget(nums, 0, index, target);
		} else {
			if (nums[index] < target || nums[index + 1] > target) {
				return -1;
			} else if (nums[0] <= target) {
				return searchTarget(nums, 0, index, target);
			} else {
				return searchTarget(nums, index + 1, nums.length - 1, target);
			}
		}
	}

	public int searchBiggest(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		//最大值下标
		int mid = r;
		while (nums[l] >= nums[r]) {
			if (r - l <= 1) {
				mid = l;
				break;
			}
			mid = (l + r) >> 1;
			if (nums[mid] >= nums[l]) {
				l = mid;
			} else {
				r = mid;
			}
		}
		return mid;
	}

	public int searchTarget(int[] nums, int from, int to, int target) {
		if (nums == null || nums.length == 0
				|| from < 0 || to > nums.length || from > to) {
			return -1;
		}
		int mid;
		while (from <= to&& to < nums.length) {
			mid = (from + to) >> 1;
			if (nums[mid] > target ) {
				to = mid - 1;
			} else if (nums[mid] < target) {
				from = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	@Test
	public void test() {
		search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
	}
}
