package Hot100.MultiDimensionDynamicProgramming;


// 最长公共子序列
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; ++i) dp[i][0] = 0;
        for (int j = 0; j < len2; ++j) dp[0][j] = 0;
        for (int i = 1; i <= len1; ++i)
            for (int j = 1; j <= len2; ++j)
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        return dp[len1][len2];
    }
}
