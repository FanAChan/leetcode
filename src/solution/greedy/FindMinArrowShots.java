package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {


        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = o1[1] - o2[1];
                if(0 == i){
                    return o1[0] - o2[0];
                }
                return i;
            }
        });

        int i = 0;
        int result = 0;
        while (i < points.length){
            int[] point = points[i];

            int target = point[1];
            result++;
            if(i == points.length -1){
                break;
            }
            int j = i + 1;
            while (j < points.length){
                if(points[j][0] > target || points[j][1] < target){
                    i = j;
                    break;
                }
                j++;
            }
            if(j == points.length){
                break;
            }

        }
        return result;
    }

    @Test
    public void test() throws Exception {
        int[][] arr = {{1,2},{2,3},{3,4},{4,5}};
        Assert.assertEquals(4,findMinArrowShots(arr));
    }
}
