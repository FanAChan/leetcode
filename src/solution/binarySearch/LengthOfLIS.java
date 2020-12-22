package solution.binarySearch;

import org.junit.Test;

/**
 * 最长递增子序列
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if(null == nums || nums.length == 0){
            return 0;
        }

        int[] result = new int[nums.length];

        int LIS = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            result[i] = 1;
            for(int j = i - 1;j >= 0;j--){
                if(nums[i] > nums[j]){
                    result[i] = Math.max(result[i],result[j] + 1);
                }
            }
            LIS = Math.max(result[i],LIS);
        }
        return LIS;
    }

    @Test
    public void test(){
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        lengthOfLIS.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
