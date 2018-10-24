package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/7 23:21
 **/
public class FindMinimuminRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int start = 0;
		int end = nums.length - 1;
		if(nums[start] < nums[end]){
			return nums[start];
		}
		while (start < end - 1) {
			int mid = (end + start) / 2;
			if(nums[start] < nums[mid]){
				start = mid;
			}else {
				end = mid;
			}
		}
		return nums[end];
	}

	@Test
	public void test(){
		findMin(new int[]{3,4,5,1,2});
		findMin(new int[]{1,2,3,4,5});
		findMin(new int[]{4,5,6,7,0,1,2});
	}
}
