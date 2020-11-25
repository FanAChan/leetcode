package solution;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        String result = "";
        int len = 0;

        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = charArray[i] == charArray[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && charArray[i] == charArray[j];
                }

                if (dp[i][j] && l + 1> len) {
                    len = l;
                    result = s.substring(i, j + 1);
                }
            }
        }

        return result;
    }
}
