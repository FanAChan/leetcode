package solution.divideconquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length / 2;
        return nums[index];

    }

    public int majorityElement2(int[] nums) {

        int major = 0;

        int count = 0;

        for (int num : nums) {
            if(count == 0){
                major = num;
                count++;
            }else if(major == num){
                count++;
            }else {
                count--;
            }
        }
        return major;

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(3,majorityElement2(new int[]{3,2,3}));
        Assert.assertEquals(1,majorityElement2(new int[]{1}));
    }

}
