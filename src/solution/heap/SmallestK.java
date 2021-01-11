package solution.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestK {


    public int[] smallestK(int[] arr, int k) {

        if(k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i1 : arr) {

            if (queue.size() < k) {
                queue.add(i1);
            } else {
                if (queue.peek() > i1) {
                    queue.poll();
                    queue.add(i1);
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;

    }
}
