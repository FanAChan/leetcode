package solution;

import java.util.Stack;

/**
 * @author Achan
 * @date 2018/4/5 13:38
 **/
public class SetMismatch {
    public static int[] findErrorNums2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int result = nums[0];
        int numsTotal = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            numsTotal += nums[i];
            result &= nums[i];
        }
        int missNum = result - (numsTotal - ((1 + length) >> 1) * length);
        System.out.println(result + "----" + missNum);
        return new int[]{result, missNum};
    }

    public static void main(String[] args) {
//        int[] nums = {4,2,2,1};
//        findErrorNums(nums);
//        long n = 8;
//        int m = 2;
//        if (n % (m<<1) != 0){
//            System.out.println(-1);
//            return;
//        }
//        System.out.println(n*m>>1);










    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }
}
