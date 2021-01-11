package solution.heap;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {


        if(null == matrix || matrix.length == 0){
            return -1;
        }
        int n = matrix.length;

        if(k > n * n){
            return -1;
        }
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return matrix[o1.getKey()][o1.getValue()] - matrix[o2.getKey()][o2.getValue()];
            }
        });

        for (int i = 0; i < n; i++) {
            Pair<Integer, Integer> temp = new Pair<>(i, 0);
            queue.add(temp);
        }

        int i = 1;

        while (i < k){
            Pair<Integer, Integer> pair = queue.poll();

            if(pair.getValue() < n - 1) {
                queue.add(new Pair<>(pair.getKey(), pair.getValue() + 1));
            }
            i++;
        }
        Pair<Integer, Integer> pair = queue.poll();
        return matrix[pair.getKey()][pair.getValue()];


    }

    @Test
    public void test() throws Exception {

        int[][] temp = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};


        Assert.assertEquals(13,kthSmallest(temp,8));
    }
}
