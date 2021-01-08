package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class MinSubArrayLen {


    public int minSubArrayLen(int s, int[] nums) {


        if (null == nums || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        int sum = 0;
        boolean exist = false;
        while (start <= end && end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                exist = true;
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return exist ? min : 0;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
