package solution.backTrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> resultList = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        backTrace(resultList,nums,temp,0);
        System.out.println(resultList);
        return resultList;
    }

    private void backTrace(List<List<Integer>> result,int[] nums,List<Integer> temp,int start){

        result.add(new ArrayList<>(temp));
        if(start == nums.length){
            return;
        }

        for (int i = start; i < nums.length; i++) {

            temp.add(nums[i]);
            backTrace(result,nums,temp,i+1);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() throws Exception {

        subsets(new int[]{1,2,3});
    }

}
