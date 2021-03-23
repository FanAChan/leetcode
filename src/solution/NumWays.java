package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class NumWays {

    public int numWays(String s) {


        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                count++;
                map.put(count,i);
            }
        }
        if(count % 3 != 0){
            return 0;
        }
        if(count == 0){
            if(s.length() < 3){
                return 0;
            }
            return  (int)(((long)(s.length() -2))* ((long)(s.length()  - 1))/2 % 1000000007) ;
        }
        Integer i1 = map.get(count / 3);
        Integer i2 = map.get(count / 3 + 1);
        Integer i3 = map.get(2 * count / 3);
        Integer i4 = map.get(2 * count / 3 + 1);

        long i = (i2 - i1 );
        long j = ((i4-i3) );

        return  (int)(i * j % 1000000007);
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(numWays("10101"),4);
        Assert.assertEquals(numWays("1001"),0);
        Assert.assertEquals(numWays("0000"),3);
        Assert.assertEquals(numWays("100100010100110"),12);
    }


}
