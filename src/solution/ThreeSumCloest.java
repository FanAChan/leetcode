package solution;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Achan
 * @date 2018/11/2 10:28
 **/
public class ThreeSumCloest {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int result = 0;
		boolean positive = true;
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			int start = i + 1;
			int end = len - 1;
			while (start < end) {
				int sum = nums[start] + nums[end] + nums[i];
				int temp = target - sum;
				if (temp < 0) {
					if (-temp < min) {
						result = sum;
						min = -temp;
					}
					end--;
				} else {
					if (temp < min) {
						result = sum;
						min = temp;
					}
					start++;
				}
			}
		}
		return result;
	}

	@Test
	public void test() {
//		threeSumClosest(new int[]{0, 2, 1, -3}, 1);
//		threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
		threeSumClosest(new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33}, 0);
	}
}
