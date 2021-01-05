package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LargestSumAfterKNegations {


    public int largestSumAfterKNegations(int[] A, int K) {


        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : A) {
            if(K > 0 && i < 0){
                i = -i;
                K--;
            }
            min = Math.min(min,i);
            sum += i;
        }
        if((K & 1) != 0){
            sum = sum - min * 2;
        }

        return sum;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(5,largestSumAfterKNegations(new int[]{4,2,3},1));
        Assert.assertEquals(6,largestSumAfterKNegations(new int[]{3,-1,0,2},3));
        Assert.assertEquals(13,largestSumAfterKNegations(new int[]{2,-3,-1,5,-4},2));
    }
}
