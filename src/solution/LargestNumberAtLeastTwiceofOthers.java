package solution;

/**
 * @author Achan
 * @date 2018/4/2 23:37
 * <p>
 * In a given integer array nums, there is always exactly one largest element.
 * <p>
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * <p>
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 **/
public class LargestNumberAtLeastTwiceofOthers {

    public static int dominantIndex(int[] nums) {

        if(nums == null || nums.length < 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        int index = 0;
        if(nums[0] > nums[1]){
            index = 0;
        }else {
            index = 1;
        }
        int max = nums[index];
        int second = nums[0] + nums[1] - max;


        for (int i = 2; i < nums.length; i++) {
            if (max < nums[i]) {
                index = i;
                second = max;
                max = nums[i];
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        if((max>>1)>=second){
            return index;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(6>>1);
        int[] array = {0,0,0,1};
        int[] array2 = {1};
        int[] nums = {1, 2, 3, 4};
        System.out.println(dominantIndex(array2));
        System.out.println(dominantIndex(null));
        System.out.println(dominantIndex(array));
        System.out.println(dominantIndex(nums));
    }
}
