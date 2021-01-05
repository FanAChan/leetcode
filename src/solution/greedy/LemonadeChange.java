package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {


        int fiveNum = 0;
        int tenNum = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveNum++;
            } else if (bill == 10) {
                if (fiveNum == 0) {
                    return false;
                }
                fiveNum--;
                tenNum++;
            } else if (bill == 20) {
                if (fiveNum > 0 && tenNum > 0) {
                    tenNum--;
                    fiveNum--;
                } else if (fiveNum > 3) {
                    fiveNum -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        Assert.assertTrue(lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        Assert.assertTrue(lemonadeChange(new int[]{5, 5, 10}));
        Assert.assertFalse(lemonadeChange(new int[]{10, 10}));
        Assert.assertFalse(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
