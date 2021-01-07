package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxEvents {


    /**
     * 1,根据开始时间排序
     * 2,将当前可进行的会议的结束时间放入优先级队列中
     * 3,选中可参加会议中结束时间最早的会议（其它会议可在之后参加）
     * 4,移除结束时间小于当前时间的会议，已不可参加
     */
    public int maxEvents(int[][] events) {

        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int day = events[0][0];
        int num = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int i = 0;

        while (i < events.length || !queue.isEmpty()) {

            while (i < events.length && events[i][0] == day) {
                queue.add(events[i][1]);
                i++;
            }
            if (!queue.isEmpty()) {
                queue.poll();
                num++;
            }
            while (!queue.isEmpty() && queue.peek() <= day) {
                queue.poll();
            }
            day++;
        }

        return num;
    }

    @Test
    public void test() throws Exception {
        int[][] arr = {{1, 1}, {1, 4}, {4, 4}, {2, 2}, {3, 4}};
        int[][] arr2 = {{1, 2}, {2, 3}, {3, 4}};
//        Assert.assertEquals(4,maxEvents(arr));
        Assert.assertEquals(3, maxEvents(arr2));
    }
}
