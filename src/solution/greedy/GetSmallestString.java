package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class GetSmallestString {


    public String getSmallestString(int n, int k) {

        StringBuilder stringBuilder = new StringBuilder();

        //优先使用 a
        //无法使用a时使用可使用的最小值

        //无法使用a的情况
        int i = (n - 1) * 26;

        while (i >= k){
            stringBuilder.append('a');
            k--;
            n--;
            i = (n - 1) * 26;
        }
        if( k % 26 != 0) {
            stringBuilder.append((char) (k % 26 - 1 + 'a'));
            n--;
        }
        while (n > 0){
            stringBuilder.append('z');
            n--;
        }
        return stringBuilder.toString();

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals("aay",getSmallestString(3,27));
        Assert.assertEquals("aaszz",getSmallestString(5,73));
        Assert.assertEquals("zzzzz",getSmallestString(5,130));
    }
}
