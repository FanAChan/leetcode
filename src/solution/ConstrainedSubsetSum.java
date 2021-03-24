package solution;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ConstrainedSubsetSum {

    public int constrainedSubsetSum(int[] nums, int k) {
        if(null == nums || nums.length == 0){
            return -1;
        }
        //滑动窗口
        int[] sumArray = Arrays.copyOf(nums, nums.length);
        Deque<Pair<Integer,Integer>> deque = new LinkedList<>();
        int result = sumArray[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int max = 0;
            while (!deque.isEmpty()){
                Pair<Integer, Integer> first = deque.getFirst();
                if(first.getValue() < i - k){
                    deque.removeFirst();
                    continue;
                }else {
                    if (first.getKey() > max) {
                        max = first.getKey();
                    }
                    break;
                }
            }
            sumArray[i] = max + num;
            while (!deque.isEmpty()){
                if (deque.getLast().getKey() < sumArray[i]) {
                    deque.removeLast();
                }else{
                    break;
                }
            }
            deque.addLast(new Pair<>(sumArray[i],i));
            result = Math.max(sumArray[i],result);
        }
        return result;
    }

    @Test
    public void test() throws Exception {
//        Assert.assertEquals(constrainedSubsetSum(new int[]{1,2,3}, 2),6);
//        Assert.assertEquals(constrainedSubsetSum(new int[]{10,2,-10,5,20},2),37);
//        Assert.assertEquals(constrainedSubsetSum(new int[]{-1,-2,-3},1),-1);
        Assert.assertEquals(constrainedSubsetSum(new int[]{10,-2,-10,-5,20},2),23);
    }
}
