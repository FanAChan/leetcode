package solution.dp;

public class MaximizeTotalCostOfAlternatingSubarrays_3196 {


    public static long maximumTotalCost(int[] nums) {


        long[] dp = new long[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i + 1] = Math.max(dp[i] + nums[i], dp[i - 1] + nums[i - 1] - nums[i]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(maximumTotalCost(new int[]{1,-2,3,4}));
        System.out.println(maximumTotalCost(new int[]{1,-1,1,-1}));
        System.out.println(maximumTotalCost(new int[]{0}));
        System.out.println(maximumTotalCost(new int[]{1,-1}));
        System.out.println(maximumTotalCost(new int[]{-14,-13,-20}));
    }
}
