package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class MinCost {

    public int minCost(String s, int[] cost) {

        if(null == s || null == cost || s.length() <= 1){
            return 0;
        }

        char[] charArray = s.toCharArray();
        char pre = charArray[0];
        int preIndex = 0;
        int result = 0;
        for (int i = 1; i < charArray.length; i++) {

            if(pre != charArray[i]){
                pre = charArray[i];
                preIndex = i;
            }else{
                if(cost[i] > cost[preIndex]){
                    result += cost[preIndex];
                    preIndex = i;
                }else{
                    result += cost[i];
                }
            }

        }
        return result;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(3,minCost("abaac",new int[]{1,2,3,4,5}));
        Assert.assertEquals(0,minCost("abc",new int[]{1,2,3}));
        Assert.assertEquals(2,minCost("aabaa",new int[]{1,2,3,4,1}));
    }
}
