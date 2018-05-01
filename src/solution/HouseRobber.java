package solution;

/**
 * @author Achan
 * @date 2018/4/27 22:25
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 **/
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] temps = new int[length + 1];
        temps[0] = nums[0];
        if (length >= 2) {
            temps[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                temps[i] = Math.max(temps[i - 1], temps[i - 2] + nums[i]);
            }
        }
        return temps[length - 1];
    }
}
