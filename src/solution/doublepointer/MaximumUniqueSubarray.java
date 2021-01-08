package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import javax.management.loading.MLet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarray {


    public int maximumUniqueSubarray(int[] nums) {

        if(null == nums || nums.length == 0){
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 0;

        int temp = 0;
        Set set = new HashSet<Integer>();

        while (left <= right && right < nums.length) {
            if(set.add(nums[right])) {
                temp += nums[right];
                max = Math.max(max,temp);
                right++;
            }else{
                set.remove(nums[left]);
                temp-= nums[left];
                left++;
            }
        }
        return max;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(17,maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }
}
