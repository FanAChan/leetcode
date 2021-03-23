package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class MinKBitFlips {

    public int minKBitFlips(int[] A, int K) {


        int start = 0;
        int end = K - 1;

        int count = 0;
        while (end < A.length) {
            if (A[start] == 1) {
                start++;
                end++;
            } else {
                for (int i = start; i <= end; i++) {
                    A[i] = 1 - A[i];
                }
                count++;
            }
        }
        for (int i = start; i < end; i++) {
            if (A[i] == 0) {
                return -1;
            }
        }
        return count;

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(minKBitFlips(new int[]{0, 1, 0}, 2), 2);
        Assert.assertEquals(minKBitFlips(new int[]{1, 1, 0}, 2), -1);
        Assert.assertEquals(minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3), 3);
    }
}
