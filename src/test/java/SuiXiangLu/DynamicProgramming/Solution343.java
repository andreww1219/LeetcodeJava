package SuiXiangLu.DynamicProgramming;


// 整数拆分
public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j <= i - j; ++j) {
                dp[i] = Math.max((i - j) * j,
                        Math.max(dp[i - j] * dp[j], dp[i]));
            }
        }
        return dp[n];
    }
}
