package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {


        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(num,maxNum);
        }
        int[] dp = new int[maxNum + 1];
        int[] count = new int[maxNum + 1];
        for (int num : nums) {
            count[num]++;
        }
        dp[1] = count[1];

        for(int i = 2;i<= maxNum;i++){
            int max = Math.max(dp[i - 1], dp[i - 2] + count[i] * i);
            dp[i] = max;
        }
        return dp[maxNum];

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(deleteAndEarn(new int[]{3,4,2}),6);
    }
}
