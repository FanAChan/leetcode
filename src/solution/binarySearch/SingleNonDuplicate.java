package solution.binarySearch;

import org.junit.Test;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {

        if(null == nums){
            return -1;
        }
        if(1 == nums.length){
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + (right - left )/2;
            //左半边数组元素是否为偶数个
            boolean b = ((mid - left) & 1) != 0;
            //左半边为偶数个元素，则当前元素应与左边元素相同
            if(b){
                if(nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }else{
                //左半边为奇数个元素，则当前元素应与右边元素相同
                //当与右边元素相同时，说明左边无单一元素，left = mid + 2
                //当与右边元素不相同时，说明单一元素在左侧，right = mid；
                if(nums[mid] == nums[mid + 1]){
                    left = mid + 2;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }

    @Test
    public void test(){

        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}
