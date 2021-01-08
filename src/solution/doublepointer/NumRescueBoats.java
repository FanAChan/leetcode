package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumRescueBoats {


    public int numRescueBoats(int[] people, int limit) {


        if(null == people || people.length == 0){
            return 0;
        }

        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        int num = 0;
        while (start < end) {
            if (limit - people[end] >= people[start]) {
                num++;
                start ++;
                end--;
            } else {
                num++;
                end--;
            }
        }
        if (start == end) {
            num++;
        }

        return num;
    }

    @Test
    public void test() throws Exception {


        Assert.assertEquals(1,numRescueBoats(new int[]{1,2},3));
        Assert.assertEquals(3,numRescueBoats(new int[]{3,2,2,1},3));
        Assert.assertEquals(4,numRescueBoats(new int[]{3,5,3,4},5));
    }

}
