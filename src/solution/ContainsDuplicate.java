package solution;

import java.util.HashSet;

/**
 * @author Achan
 * @date 2018/5/7 11:53
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 **/
public class ContainsDuplicate {

	public static boolean containsDuplicate(int[] nums) {

		if(nums == null || nums.length == 0){
			return false;
		}
		boolean result = true;
		HashSet<Object> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!set.add(num)) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[]{1,2,3,1}));
	}
}
