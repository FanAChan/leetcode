package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SubarraysDivByK {

    public int subarraysDivByK(int[] A, int K) {

        int length = A.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            sum += A[i];
            int temp = (sum % K + K) % K;
            Integer num = map.getOrDefault(temp, 0);
            map.put(temp, num + 1);
        }

        for (int i = 0; i < K; i++) {
            Integer num = map.getOrDefault(i, 0);
            if (i == 0) {
                count += num;
            }
            count += num * (num - 1) / 2;
        }
        return count;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5), 7);
        Assert.assertEquals(subarraysDivByK(new int[]{-1, 2, 9}, 2), 2);
        Assert.assertEquals(subarraysDivByK(new int[]{-8, 1, 4, 1}, 10), 0);
    }

}
