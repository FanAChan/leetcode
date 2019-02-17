package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/25 19:17
 **/
public class RemoveDuplicatessfromSortedArray {



	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int cur = 1;
		int index = 0;
		while (cur < nums.length) {
			if (nums[cur] != nums[index]) {
				index++;
				nums[index] = nums[cur];
			}
			cur++;
		}
		return index + 1;


	}

	@Test
	public void test() {

	}
}
