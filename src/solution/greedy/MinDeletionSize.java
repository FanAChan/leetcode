package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class MinDeletionSize {

    public int minDeletionSize(String[] A) {

        if(null == A || A.length == 0){
            return 0;
        }

        int result = 0;
        int stringLen = A[0].length();

        if(stringLen == 0){
            return 0;
        }
        for (int i = 0; i < stringLen; i++) {
            char pre = 'a';
            for (int j = 0; j < A.length; j++) {
                if (pre > A[j].charAt(i)) {
                    result++;
                    break;
                }
                pre = A[j].charAt(i);

            }
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(1, minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        Assert.assertEquals(0, minDeletionSize(new String[]{"a", "b"}));
        Assert.assertEquals(3, minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
    }
}
