package solution.divideconquer;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArray {


    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int result = preSum;
        for (int j = 1; j < nums.length; j++) {
            int num = nums[j];
            preSum = preSum > 0 ? preSum + num : num;
            result = Math.max(result, preSum);

        }
        return result;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(6,maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }


}
