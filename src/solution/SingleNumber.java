package solution;

/**
 * @author Achan
 * @date 2018/8/7 22:44
 **/
public class SingleNumber {

	public static int singleNumber(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			result ^= num;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{4,1,2,1,2}));
	}
}
