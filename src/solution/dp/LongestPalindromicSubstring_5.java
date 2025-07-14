package solution.dp;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 */

/**
 * 定义f[i][j]为字符串s的第i个字符到第j个字符的子字符串的最长回文字符串
 * 则结果为f[0][s.len]
 * 状态转移方程
 * f[i][j] =
 */
public class LongestPalindromicSubstring_5 {

    public static String longestPalindrome(String s) {

        char[] charArray = s.toCharArray();


        int maxLen = -1;
        String result = "";

        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                boolean palindromString = isPalindromString(charArray, i, j);
                if (palindromString && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    private static boolean isPalindromString(char[] charArray, int fromIndex, int endIndex) {
        if (fromIndex == endIndex) {
            return true;
        }
        while (endIndex > fromIndex) {
            if (charArray[fromIndex] == charArray[endIndex]) {
                fromIndex++;
                endIndex--;
                continue;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeByEx("abba"));
        System.out.println(longestPalindromeByEx("babad"));
        System.out.println(longestPalindromeByEx("bad"));
        System.out.println(longestPalindromeByEx("cbbd"));
        System.out.println(longestPalindromeByEx("ccc"));

    }


    public static String longestPalindromeByDP(String s) {

        char[] charArray = s.toCharArray();
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 2; j <= length; j++) {
            for (int i = 0; i + j - 1 < length; i++) {
                if (j == 2) {
                    if (charArray[i] == charArray[i + 1]) {
                        dp[i][i + 1] = true;
                    }
                } else {
                    if (charArray[i] == charArray[i + j - 1]) {
                        dp[i][i + j - 1] = dp[i + 1][i + j - 2];
                    }
                }
            }
        }
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }


    public static String longestPalindromeByEx(String s) {

        int maxLen = 0;
        String longestSubString = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = longestPalindromicStringEx(s, i, i);
            String s2 = longestPalindromicStringEx(s, i, i + 1);
            if(maxLen < s1.length()){
                longestSubString = s1;
                maxLen = s1.length();
            }
            if(maxLen < s2.length()){
                longestSubString = s2;
                maxLen = s2.length();
            }
        }
        return longestSubString;
    }

    private static String longestPalindromicStringEx(String s, int start, int end) {
        String subString = "";
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                subString = s.substring(start, end + 1);
                start--;
                end++;
            } else {
                break;
            };
        }

        return subString;
    }
}
