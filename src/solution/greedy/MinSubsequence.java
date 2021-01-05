package solution.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        if(null == nums || nums.length == 0){
            return result;
        }

        Arrays.sort(nums);
        int sum = 0 ;
        for (int num : nums) {
            sum += num;
        }


        int subSum = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            subSum += nums[i];
            result.add(nums[i]);
            if(subSum > sum - subSum){
                break;
            }
        }

        return result;
    }

    @Test
    public void test() throws Exception {
        System.out.println(minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(minSubsequence(new int[]{4,4,7,6,7}));
        System.out.println(minSubsequence(new int[]{6}));
    }

}
