package solution;

import org.junit.Assert;
import org.junit.Test;

public class CountVowelStrings {


    public int countVowelStrings(int n) {


        int result = 0;

        for(int i = 0;i<5;i++){
            int temp = 1;
            int tempN = n;
            while (tempN > 1){
                temp *= (5 - i);
                tempN--;
            }
            result+= temp;
        }
        return result;

    }

    @Test
    public void test() throws Exception {
//        Assert.assertEquals(countVowelStrings(1),5);
//        Assert.assertEquals(countVowelStrings(2),15);
        Assert.assertEquals(countVowelStrings(33),66045);
    }
}
