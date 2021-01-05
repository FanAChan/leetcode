package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class BalancedStringSplit {


    public int balancedStringSplit(String s) {


        int result = 0;

        int i = 0;

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(c == 'R'){
                i++;
            }else if(c == 'L'){
                i--;
            }
            if(i == 0){
                result ++;
            }
        }
        return result;
    }

    @Test
    public void test() throws Exception {

        Assert.assertEquals(4,balancedStringSplit("RLRRLLRLRL"));
        Assert.assertEquals(3,balancedStringSplit("RLLLLRRRLR"));
        Assert.assertEquals(1,balancedStringSplit("LLLLRRRR"));
    }
}
