package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class CanArrange {

    public boolean canArrange(int[] arr, int k) {

        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {

            int index = arr[i] % k;
            if(index < 0){
                index += k;
            }
            count[index] ++;
        }

        int i = 1;
        while (i < k){
            if(count[i] != count[k - i]){
                return false;
            }
            i++;
        }
        //判断可以被k整除的数的数量是否为偶数
        return (count[0] & 1) == 0;
    }

    @Test
    public void test() throws Exception {
//        Assert.assertTrue(canArrange(new int[]{1,2,3,4,5,10,6,7,8,9},5));
//        Assert.assertTrue(canArrange(new int[]{1,2,3,4,5,6},7));
//        Assert.assertFalse(canArrange(new int[]{1,2,3,4,5,6},10));
//        Assert.assertTrue(canArrange(new int[]{-10,10},2));
        Assert.assertTrue(canArrange(new int[]{-1,1,-2,2,-3,3,-4,4},3));

    }
}
