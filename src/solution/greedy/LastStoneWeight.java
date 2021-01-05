package solution.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int abs = Math.abs(queue.poll() - queue.poll());
            if (abs > 0) {
                queue.offer(abs);
            }
        }
        return queue.size() == 0 ? 0 : queue.poll();

    }
}
