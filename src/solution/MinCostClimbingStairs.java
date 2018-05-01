package solution;

/**
 * @author Achan
 * @date 2018/4/27 23:34
 * <p>
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * <p>
 * Example 2:
 * <p>
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 **/
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int[] temps = new int[2];
        if(cost == null || cost.length <= 1){
            return 0;
        }
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        temps[0] = cost[0];
        temps[1] = cost[1];
        for(int i = 2;i<cost.length;i++){
            int t = temps[1];
            temps[1] = Math.min(cost[i]+temps[0],temps[1]+cost[i]);
            temps[0] = t;
        }
        return Math.min(temps[0],temps[1]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0,0,1,1}));
    }
}
