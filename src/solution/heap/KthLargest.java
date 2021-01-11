package solution.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {


    Queue<Integer> queue;

    int k = 0;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));

        this.k = k;
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
