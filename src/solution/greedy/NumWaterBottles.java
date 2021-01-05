package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + numWaterEmptyBottles(numBottles,numExchange);
    }

    public int numWaterEmptyBottles(int emptyBottles,int numExchange) {
        if(emptyBottles < numExchange){
            return 0;
        }
        int num = emptyBottles / numExchange;
        return num + numWaterEmptyBottles(emptyBottles % numExchange + num,numExchange);
    }

    @Test
    public void test() throws Exception {

        Assert.assertEquals(13,numWaterBottles(9,3));
        Assert.assertEquals(19,numWaterBottles(15,4));
        Assert.assertEquals(6,numWaterBottles(5,5));
        Assert.assertEquals(2,numWaterBottles(2,3));
    }
}
