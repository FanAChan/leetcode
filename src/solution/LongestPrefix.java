package solution;

import org.junit.Assert;
import org.junit.Test;

public class LongestPrefix {

    public String longestPrefix(String s) {


        int n = s.length();
        int i = n - 1;
        while (i >0){
            if(s.substring(0,i).equals(s.substring(n-i))){
                return s.substring(0,i);
            }
            i--;
        }
        return "";

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(longestPrefix("level"),"l");
    }

}
