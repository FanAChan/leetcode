package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetNumberOfBacklogOrders {

    public int getNumberOfBacklogOrders(int[][] orders) {


        //最小堆
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //最大堆
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int[] order : orders) {

            int[] count = {order[0], order[1]};
            // buy
            if (order[2] == 0) {
                while (!sellQueue.isEmpty()) {
                    int[] sell = sellQueue.peek();
                    if (sell[0] <= count[0]) {
                        sellQueue.poll();
                        if (sell[1] > count[1]) {
                            sell[1] = sell[1] - count[1];
                            count[1] = 0;
                            sellQueue.add(sell);
                            break;
                        } else {
                            count[1] = count[1] - sell[1];
                        }
                    } else {
                        break;
                    }
                }
                if (count[1] > 0) {
                    buyQueue.add(count);
                }
            } else {
                while (!buyQueue.isEmpty()) {
                    int[] buy = buyQueue.peek();
                    if (buy[0] >= count[0]) {
                        buyQueue.poll();
                        if (buy[1] > count[1]) {
                            buy[1] = buy[1] - count[1];
                            count[1] = 0;
                            buyQueue.add(buy);
                            break;
                        } else {
                            count[1] = count[1] - buy[1];
                        }
                    } else {
                        break;
                    }

                }
                if (count[1] > 0) {
                    sellQueue.add(count);
                }
            }
        }


        long count = 0;
        for (int[] ints : buyQueue) {
            count += ints[1];
            count %= 1000000007;
        }
        for (int[] ints : sellQueue) {
            count += ints[1];
            count %= 1000000007;
        }
        return (int) count;
    }

    @Test
    public void test() throws Exception {

        int[][] ints = new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        int[][] int2 = new int[][]{{16,24,0},{16,2,1},{23,28,1},{21,6,0},{17,8,0},{25,7,0}};

//        Assert.assertEquals(getNumberOfBacklogOrders(ints),6);
        Assert.assertEquals(getNumberOfBacklogOrders(int2),57);
    }
}
