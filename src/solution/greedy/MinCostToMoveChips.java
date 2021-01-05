package solution.greedy;

import org.junit.Test;

public class MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {

        int num = 0;
        for (int i : position) {
            num += i & 1;
        }

        return Math.min(num,position.length - num);
    }

    @Test
    public void test() throws Exception {

        System.out.println(minCostToMoveChips(new int[]{1,2,3}));
        System.out.println(minCostToMoveChips(new int[]{2,2,2,3,3}));
    }

}
