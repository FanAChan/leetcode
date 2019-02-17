package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/27 10:09
 **/
public class SearchBinary {


	public int searchBinary(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0;
		int r = nums.length;
		int mid;
		while (l <= r && r < nums.length) {
			mid = (l + r) >> 1;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;

	}

	@Test
	public void test() {

	}
}
