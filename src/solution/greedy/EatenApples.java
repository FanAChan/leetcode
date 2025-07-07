package solution.greedy;

import cn.hutool.core.lang.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EatenApples {


    public int eatenApples(int[] apples, int[] days) {

        int i = 0;

        int num = 0;
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        while (i < apples.length || !queue.isEmpty()) {
            if(i < apples.length && apples[i] > 0 ){
                queue.add(new Pair<>(i + days[i] - 1, apples[i]));
            }
            if (!queue.isEmpty()) {
                Pair<Integer, Integer> poll = queue.poll();
                if (poll.getValue() > 1) {
                    queue.add(new Pair<Integer, Integer>(poll.getKey(), poll.getValue() - 1));
                }
                num++;
            }
            while (!queue.isEmpty() && queue.peek().getKey() <= i) {
                queue.poll();
            }
            i++;
        }
        return num;
    }

    @Test
    public void test() throws Exception {

        Assert.assertEquals(7, eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        Assert.assertEquals(5, eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
    }
}
