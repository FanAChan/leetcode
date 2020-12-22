package solution.binarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinOperations {


    //查询最长子数组 使得数组sum + x = numSum
    public int solution(int[] nums, int x) {

        if(null == nums || nums.length == 0 || x <= 0){
            return -1;
        }
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        int tempSum = 0;
        int result = -1;
        int left = 0;
        int right = 0;
        while (left <= right && right < nums.length){
            tempSum+=nums[right];
            while (tempSum + x > sum && left <= right){
                tempSum -= nums[left];
                left++;
            }
            if(tempSum + x == sum){
                result = Math.max(result,right - left + 1);
            }
            right++;
        }
        return result == -1? -1:nums.length - result;
    }

    @Test
    public void test() throws Exception {
        MinOperations minOperations = new MinOperations();
        int[] ints = {1, 1, 4, 2, 3};
        Assert.assertEquals(2,minOperations.solution(ints,5));
        Assert.assertEquals(-1,minOperations.solution(new int[]{5,6,7,8,9},4));
        Assert.assertEquals(5,minOperations.solution(new int[]{3,2,20,1,1,3},10));
    }
}
