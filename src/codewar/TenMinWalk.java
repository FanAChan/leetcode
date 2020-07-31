package codewar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TenMinWalk {

    public static boolean isValid(char[] walk) {
        // Insert brilliant code here
        if(null == walk || walk.length != 10){
            return false;
        }
        int n_s = 0;
        int w_e = 0;
        for (char c : walk) {
            switch (c){
                case 'n':
                    n_s++;
                    break;
                case 's':
                    n_s--;
                    break;
                case 'w':
                    w_e++;
                    break;
                case 'e':
                    w_e--;
                    break;
                default:

            }
        }
        return 0 == n_s && 0 == w_e ;
    }

    @Test
    public void Test() {
        assertEquals("Should return true", true, TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }
}
