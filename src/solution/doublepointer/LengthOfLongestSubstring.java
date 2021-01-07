package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {


        if(null == s || s.length() == 0){
            return 0;
        }
        int max = 1;
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.add(c)) {
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                while (left <= right) {
                    set.remove(s.charAt(left));
                    if (s.charAt(left++) == c) {
                        break;
                    }
                }
            }
        }
        return max;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1,lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3,lengthOfLongestSubstring("pwwkew"));
    }
}
