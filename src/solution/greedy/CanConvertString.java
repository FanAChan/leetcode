package solution.greedy;

import org.junit.Assert;
import org.junit.Test;

public class CanConvertString {

    public boolean canConvertString(String s, String t, int k) {

        if(null == s && null == t){
            return true;
        }
        if(null == s || null == t){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }

        int[] arr = new int[26];

        for(int i = 0;i<s.length();i++){
            arr[(t.charAt(i) - s.charAt(i) + 26) % 26]++;
        }

        for (int i = 1; i < arr.length; i++) {
            int i1 = arr[i];
            if ((i1 - 1) * 26 > k - i) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        Assert.assertTrue(canConvertString("input","ouput",9));
        Assert.assertTrue(canConvertString("aab","bbb",27));
        Assert.assertFalse(canConvertString("abc","bcd",10));
        Assert.assertFalse(canConvertString("atmtxzjkz","tvbtjhvjd",35));
    }
}
