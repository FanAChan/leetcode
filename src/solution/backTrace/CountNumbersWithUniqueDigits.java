package solution.backTrace;

import org.junit.Test;

import java.util.*;

public class CountNumbersWithUniqueDigits {


    public int countNumbersWithUniqueDigits(int n) {
        int[] num = new int[n];


return 1;

    }

    void backTrace(List<Integer> result, Stack<Integer> num, int start, int n){
        if(isDuplicateNum(num)){
        }

return;



    }

    boolean isDuplicateNum(Stack<Integer> num){
        HashSet<Integer> set = new HashSet<Integer>(num);
        return set.size() != num.size();
    }

    @Test
    public void test() throws Exception {

    }
}
