package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {

        int numS = 0;
        int numT = 0;
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            if (i >= 0 && S.charAt(i) == '#') {
                numS++;
                i--;
                continue;
            } else if (numS != 0) {
                i--;
                numS--;
                continue;
            }
            if (j >= 0 && T.charAt(j) == '#') {
                numT++;
                j--;
                continue;
            } else if (numT != 0) {
                j--;
                numT--;
                continue;
            }
            if ((j >= 0 && i >= 0)) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;


    }

    @Test
    public void test() throws Exception {


        Assert.assertTrue(backspaceCompare("bxj##tw", "bxo#j##tw"));
        Assert.assertFalse(backspaceCompare("bxj##tw", "bxj###tw"));
        Assert.assertTrue(backspaceCompare("ab##", "b#d#"));
        Assert.assertTrue(backspaceCompare("a##c", "#b#c"));
    }
}
