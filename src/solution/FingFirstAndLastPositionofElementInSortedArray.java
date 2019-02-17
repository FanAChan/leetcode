package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/27 9:39
 **/
public class FingFirstAndLastPositionofElementInSortedArray {

//	public int[] searchRange(int[] nums, int target) {
//		int[] results = new int[]{-1, -1};
//		if (nums == null || nums.length == 0) {
//			return results;
//		}
//
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == target) {
//				if (results[0] == -1) {
//					results[0] = i;
//					results[1] = i;
//				} else {
//					results[1]++;
//				}
//			}
//		}
//		return results;
//	}

	public int[] searchRange(int[] nums, int target) {
		int[] results = new int[]{-1, -1};
		if (nums == null || nums.length == 0) {
			return results;
		}

		results[0] = searchFirst(nums,target);
		results[1] = searchLast(nums,target);
		return results;
	}

	public int searchFirst(int[] nums, int target) {
		int result = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target) {
				result = mid;
			}
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return result;
	}

	public int searchLast(int[] nums, int target) {
		int result = -1;
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (nums[mid] == target) {
				result = mid;
			}
			if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}


	@Test
	public void test() {
		searchLast(new int[]{5,7,7,8,8,10},5);
	}
}
