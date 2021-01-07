package solution;

import org.junit.Assert;
import org.junit.Test;

public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int revertNum = 0;
        int temp = x;

        //为防止溢出只翻转一半的数字
        while (temp > revertNum) {

            revertNum *= 10;
            revertNum += temp % 10;
            temp /= 10;

        }
        //revertNum / 10 过滤x为奇数个数字时的中位数的影响
        return revertNum == x || x == revertNum / 10;


    }

    public boolean isPalindrome(String s) {

        if (null == s || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;

        String lowerCase = s.toLowerCase();

        while (i < j) {

            while (i < j && !Character.isLetterOrDigit(lowerCase.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(lowerCase.charAt(j))) {
                j--;
            }
            if (lowerCase.charAt(i) != lowerCase.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test() throws Exception {


        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

}
