package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        if(null == boxTypes || boxTypes.length == 0 || truckSize == 0){
            return 0;
        }

        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int sum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int[] boxType = boxTypes[i];
            if(truckSize > boxType[0]){
                sum += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            }else{
                sum += truckSize * boxType[1];
                break;
            }

        }
        return sum;
    }

    @Test
    public void test() throws Exception {

        int[][] arr = {{1,3},{2,2},{3,1}};
        Assert.assertEquals(8,maximumUnits(arr,4));
    }

}
