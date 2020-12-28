package solution.backTrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        if(k * (19 - k)/2 < n){
            return result;
        }

        backTrace(n,k,new Stack<>(),1,result,0);

        return result;
    }

    private void backTrace(int n, int k, Stack<Integer> stack,int start,List<List<Integer>> result,int sum){

        if(stack.size() > n){
            return;
        }

        if(sum == n && stack.size() == k){
            result.add(new ArrayList<>(stack));
            return;
        }
        for(int i = start;i< 10;i++){

            stack.push(i);
            sum += i;
            if(sum > n){
                stack.pop();
                sum -= i;
                break;
            }
            backTrace(n,k,stack,i+1,result,sum);
            stack.pop();
            sum -= i;
        }
    }

    @Test
    public void test() throws Exception {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> lists = combinationSum3.combinationSum3(9, 45);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
