package solution;

import java.io.Serializable;

/**
 * @author Achan
 * @date 2018/4/1 14:00
 * <p>
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * <p>
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 **/
public class FindUnsortedSubarray implements Serializable{

    public static int NUM;

    public int findUnsortedSubarray(int[] nums) {

        int max = 0;
        int min = 0;

        max++;
        int begin, end;
        return 0;
    }
}
