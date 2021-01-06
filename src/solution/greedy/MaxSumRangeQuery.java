package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxSumRangeQuery {


    /**
     * 线段树 + 贪心
     * @param nums
     * @param requests
     */
    public int maxSumRangeQuery(int[] nums, int[][] requests) {


        int num = nums.length;
        int[] count = new int[num];

        int temp = 1000000007;
        for (int[] request : requests) {
            int i = request[0];
            int j = request[1];
            count[i]++;
            if (j + 1 < num) {
                count[j + 1]--;
            }
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        Arrays.sort(count);
        Arrays.sort(nums);

        int i = num - 1;

        long sum = 0;
        for (; i >= 0 && count[i] > 0; i--) {
            sum += (long)count[i] * nums[i];
        }
        return (int) (sum % temp);

    }

    @Test
    public void test() throws Exception {
        int[][] arr = {{1, 3}, {0, 1}};
        Assert.assertEquals(19, maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, arr));
    }
}
