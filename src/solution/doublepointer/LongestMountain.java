package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class LongestMountain {

    public int longestMountain(int[] arr) {

        if (null == arr || arr.length < 3) {
            return 0;
        }

        int max = 0;
        int left = 0;

        while (left < arr.length - 2) {
            int right = left + 1;
            if (arr[left] < arr[right]) {
                while (right < arr.length - 1 && arr[right] < arr[right + 1]) {
                    right++;
                }
                if (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                        right++;
                    }
                    max = Math.max(max, right - left + 1);
                } else {
                    right++;
                }

            }
            left = right;
        }
        return max;
    }

    public int longestMountain2(int[] arr) {

        if (null == arr || arr.length < 3) {
            return 0;
        }
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }
        for (int i = arr.length - 2; i > 0; i--) {
            right[i] = arr[i + 1] < arr[i] ? right[i + 1] + 1 : 0;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(left[i] > 0 && right[i] > 0){
                max = Math.max(max,left[i] + right[i] + 1);
            }
        }
        return max;

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(5, longestMountain2(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
