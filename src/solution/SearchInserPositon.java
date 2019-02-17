package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/27 14:46
 **/
public class SearchInserPositon {

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0;
		int r = nums.length-1;
		int mid;
		while (l <= r && r < nums.length) {
			mid = (l + r) >> 1;
			if (nums[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	@Test
	public void test() {
searchInsert(new int[]{1,2,3,5,7,8},3);
	}
}
