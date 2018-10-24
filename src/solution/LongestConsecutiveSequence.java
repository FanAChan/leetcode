package solution;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Achan
 * @date 2018/6/18 21:46
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 **/
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {

		if(nums == null && nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return 1;
		}

		Set<Integer> numsSet = new HashSet<>();
		Set<Integer> usedNum = new HashSet<>();
		for (int num : nums) {
			numsSet.add(num);
		}
		int longLength = 0;
		int y = 0;
		for (int x : numsSet) {
			if (!usedNum.contains(x) && !numsSet.contains(x-1)) {
				usedNum.add(x);
				y = x + 1;
				while (numsSet.contains(y) && !usedNum.contains(y)) {
					usedNum.add(y);
					y++;
				}
				longLength = longLength > y - x ? longLength : y - x;
			}
		}
		return longLength;
	}

	@Test
	public void test() {
		System.out.println(longestConsecutive(new int[]{0,-1}));
	}
}
