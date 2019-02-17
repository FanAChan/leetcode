package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/25 19:41
 **/
public class RemoveElement {

	public int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
			j++;
		}
		return i;

	}

	public int removeElement2(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		int j = nums.length - 1;
		while (j >= i) {
			if(nums[i] == val){
				nums[i] = nums[j];
				j--;
			}else{
				i++;
			}
		}
		return i;
	}

	@Test
	public void test() {
		removeElement2(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
	}
}
