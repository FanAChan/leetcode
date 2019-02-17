package solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Achan
 * @date 2018/10/24 15:44
 **/
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}
		Arrays.sort(nums);

		LinkedList<List<Integer>> results = new LinkedList<>();
		int len = nums.length;
		for (int i = 0; i < len - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if (nums[i] > 0) {
				break;
			}
			int start = i + 1;
			int end = len - 1;
			while (start < end) {
				int temp = nums[start] + nums[end] + nums[i];
				if (temp == 0) {
					results.add(Arrays.asList(nums[i],nums[start],nums[end]));
//					ArrayList<Integer> list = new ArrayList<>();
//					list.add(nums[i]);
//					list.add(nums[start]);
//					list.add(nums[end]);
//					results.add(list);
					do {
						start++;
					} while (start < end && nums[start] == nums[start - 1]);
					do {
						end--;
					} while (start < end && nums[end] == nums[end + 1]);
				} else if (temp < 0) {
					start++;
				} else {
					end--;
				}
			}
		}
		return results;
	}

	@Test
	public void test() {
		threeSum(new int[]{-1, 0, 1, 2, -1, -4});
	}
}
