package Hot100.MultiDimensionDynamicProgramming;

import org.junit.Test;


// 最长回文子串
public class Solution5 {
    @Test
    public void test() {
        System.out.println(longestPalindrome("cbbd"));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len]; // dp[i][j] 表示 [i, j] 是否为回文子串
        int maxLen = 0;
        String ans = "";
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                if (s.charAt(j) != s.charAt(i)) continue;
                if (j - i <= 2) dp[i][j] = true;
                else dp[i][j] = dp[i + 1][j  - 1];
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }


}
