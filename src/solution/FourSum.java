package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if(null == nums || nums.length < 4){
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1;j <= nums.length - 3;j++){
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end){
                    int temp = target - nums[i] - nums[j] - nums[start] -nums[end];
                    if(temp == 0){
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        do{
                            end--;
                        }while (start < end && nums[end] == nums[end + 1]);
                        do{
                            start++;
                        }while (start < end && nums[start] == nums[start - 1]);
                    }else if(temp < 0){
                        end--;
                    }else if(temp > 0){
                        start++;
                    }
                }
                while (nums[j] == nums[j + 1] && j <= nums.length - 3){
                    j++;
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums =new int[]{0,0,0,0};
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists = fourSum.fourSum(nums, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }


    }

}
