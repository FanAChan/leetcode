package solution.backTrace;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfMatches {

    public int solution(int n) {
        if(n <= 2){
            return 1;
        }
        int result = 0;
        int i = 0;
        while (n > 1){
            i = n & 1;
            n >>= 1;
            result+= n;
            n += i;
        }
        return result;
    }

    //n个队伍 一个冠军 共需要淘汰n-1个队伍，一场比赛淘汰一个队伍
    public int solution2(int n) {
       return n -1 ;
    }


    @Test
    public void test() throws Exception {
        NumberOfMatches numberOfMatches = new NumberOfMatches();
        Assert.assertEquals(6,numberOfMatches.solution(7));
        Assert.assertEquals(13,numberOfMatches.solution(14));
    }
}
