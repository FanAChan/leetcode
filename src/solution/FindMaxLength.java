package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FindMaxLength {

    public int findMaxLength(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] countZ = new int[nums.length + 1];
        int[] countO = new int[nums.length + 1];
        int i = 1;
        for (int num : nums) {
            if (num == 1) {
                countO[i] = countO[i - 1] + 1;
                countZ[i] = countZ[i - 1];
            } else {
                countO[i] = countO[i - 1];
                countZ[i] = countZ[i - 1] + 1;
            }
            i++;
        }
        i = 0;
        int max = 0;
        for (; i < nums.length; i++) {
            for (int j = nums.length; j > i; j--) {
                if (countZ[j] - countZ[i] == countO[j] - countO[i]) {
                    max = Math.max(j - i, max);
                    break;
                }
            }
        }
        return max;
    }

    public int findMaxLength2(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> countIndexMap = new HashMap<>();
        countIndexMap.put(0,-1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count += num == 1 ? 1 : -1;
            Integer index = countIndexMap.get(count);
            if (null != index) {
                max = Math.max(i - index, max);
            } else {
                countIndexMap.put(count, i);
            }
        }

        return max;
    }


    @Test
    public void test() throws Exception {
        Assert.assertEquals(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}), 6);
    }
}
