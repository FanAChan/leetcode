package solution;

import org.junit.Test;

import java.util.Arrays;

public class MaxAbsoluteSum {


    public int maxAbsoluteSum(int[] nums) {


        int[] sum = new int[nums.length + 1];
        //计算前缀和
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum[i + 1] = sum[i] + num;
        }

        //排序
        Arrays.sort(sum);
        //获取前缀和差值最大的子数组，及最大子数组-最小最数组
        return sum[nums.length] - sum[0];


    }

    @Test
    public void test() throws Exception {
        System.out.println(maxAbsoluteSum(new int[]{-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8}));
    }

}
