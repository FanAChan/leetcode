package solution.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RestoreString {

    public String restoreString(String s, int[] indices) {

        int length = indices.length;
        char[] chars = new char[length];

        for(int i = 0;i<length;i++){
            chars[indices[i]] = s.charAt(i);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<length;i++){
            result.append(chars[i]);
        }

        return result.toString();
    }


    @Test
    public void test() throws Exception {
        Assert.assertEquals("leetcode",restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));
    }
}
