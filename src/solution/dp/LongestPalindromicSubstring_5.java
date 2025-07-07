package solution.dp;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */

/**
 * 定义f[i][j]为字符串s的第i个字符到第j个字符的子字符串的最长回文字符串
 * 则结果为f[0][s.len]
 * 状态转移方程
 *  f[i][j] =
 */
public class LongestPalindromicSubstring_5 {

    public static String longestPalindrome(String s) {

        char[] charArray = s.toCharArray();


        int maxLen = -1;
        String result = "";

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i;j < charArray.length;j++){
                boolean palindromString = isPalindromString(charArray, i, j);
                if(palindromString && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }

    private static boolean isPalindromString(char[] charArray,int fromIndex,int endIndex){
        if(fromIndex == endIndex){
            return true;
        }
        while (endIndex > fromIndex){
            if(charArray[fromIndex] == charArray[endIndex]){
                fromIndex++;
                endIndex--;
                continue;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bad"));

    }
}
