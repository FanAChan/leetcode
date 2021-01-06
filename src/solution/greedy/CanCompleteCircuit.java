package solution.greedy;

public class CanCompleteCircuit {


    /**
     *  若以i为起点时最远可达到j点，则i+1
     *
     *
     *
     *
     * @param gas
     * @param cost
     * @return
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int i = 0;
        while (i < gas.length) {
            int gasSum = 0;
            int costSum = 0;

            int count = 0;
            while (count < gas.length) {
                int index = (i + count) % gas.length;
                gasSum += gas[index];
                costSum += cost[index];

                if (gasSum < costSum) {
                    break;
                }
                count++;
            }

            if (count == gas.length) {
                return i;
            }
            i = i + count + 1;

        }
        return -1;


    }
}
