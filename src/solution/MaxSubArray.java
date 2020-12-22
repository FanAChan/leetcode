package solution;

import java.util.Arrays;

public class MaxSubArray {


    /**
     * 最大连续子数字和
     *
     * 计算以下标i结束的连续子数组的最大值，存为f(i)，f(i) = max{f(i-1) + ai,ai}
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int[] resultArray = Arrays.copyOf(nums, nums.length);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            resultArray[i] = resultArray[i-1] > 0 ? resultArray[i-1] + num : num;
            result = Math.max(resultArray[i],result);
        }
        return result;
    }
}
