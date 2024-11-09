package SuiXiangLu.DynamicProgramming;


// 最长回文子序列
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        // dp[i][j] 表示 s[i: j] 的最长回文子序列长度
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                dp[i][j] = arr[i] == arr[j]
                        ? (j - i <= 1 ? j - i + 1 : dp[i + 1][j - 1] + 2)
                        : Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }
}
