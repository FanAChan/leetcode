package solution;

/**
 * @author Achan
 * @date 2018/5/7 12:30
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 **/
public class SearchinRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return false;
		}
		int len = nums.length;
		int i = 0;
		if (nums[0] > target) {
			i = len - 1;
			while (i >= 0 && nums[i] > target) {
				i--;
			}
			if (i >= 0 && nums[i] == target) {
				return true;
			} else {
				return false;
			}
		} else {
			i = 0;
			while (i < len && nums[i] < target) {
				i++;
			}
			if (i < len && nums[i] == target) {
				return true;
			} else {
				return false;
			}
		}
	}


	public boolean searchTwo(int[] nums, int target) {
		int len = nums.length;
		int left = nums[0];
		int right = nums[len];

		return false;


	}
}
