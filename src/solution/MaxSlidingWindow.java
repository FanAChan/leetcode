package solution;

import org.junit.Test;

import java.util.*;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(nums[i]);
        }
        result[0] = queue.getFirst();
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            if (queue.getFirst() == nums[i - k]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < num) {
                queue.pollLast();
            }
            queue.addLast(num);
            result[i - k + 1] = queue.getFirst();
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5},3)));
    }
}
