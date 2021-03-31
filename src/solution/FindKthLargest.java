package solution;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() < num) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }
        }
        return priorityQueue.poll();
    }

    @Test
    public void test() throws Exception {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(6);
        queue.add(3);
        queue.add(4);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
