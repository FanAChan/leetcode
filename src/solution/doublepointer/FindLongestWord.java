package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FindLongestWord {


    public String findLongestWord(String s, List<String> d) {

        String result = "";

        for (String s1 : d) {
            if (isSubStr(s, s1)) {
                if (s1.length() == result.length()) {
                    result = s1.compareTo(result) < 0 ? s1 : result;
                } else if (s1.length() > result.length()) {
                    result = s1;
                }
            }
        }
        return result;
    }

    private boolean isSubStr(String s, String s2) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < s2.length()) {
            if (s.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == s2.length();
    }

    @Test
    public void test() throws Exception {


        Assert.assertEquals("a",findLongestWord("abpcplea", Arrays.asList("a","b","c")));
    }
}
