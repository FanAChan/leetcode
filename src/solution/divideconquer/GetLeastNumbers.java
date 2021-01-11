package solution.divideconquer;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {

        if(k == 0){
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int i = 0;
        for (Integer num : arr) {

            if(queue.size() < k){
                queue.add(num);
            }else if(queue.peek() > num){
                queue.poll();
                queue.add(num);
            }

        }

        int[] result = new int[k];
        for (Integer num : queue) {
            result[i] = num;
            i++;
        }
        return result;


    }

}
