package solution.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = o2[0] - o1[0];
                if (0 == i) {
                    return o1[1] - o2[1];
                }
                return i;
            }
        });

        LinkedList<int[]> resultList = new LinkedList<>();

        for (int[] person : people) {
            resultList.add(person[1], person);
        }
        return resultList.toArray(new int[people.length][]);


    }

    @Test
    public void test() throws Exception {

        int[][] arr = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(arr);

    }
}
