package DynamicProgramming;

// 买卖股票的最佳时机II
public class Solution122 {
    public int maxProfit1(int[] prices) {
        // dp[i][0] 表示第 i 天不持有股票的最大利润
        // dp[i][1] 表示第 i 天持有股票的最大利润
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    // 优化空间
    public int maxProfit2(int[] prices) {
        // dp[0] 表示不持有股票的最大利润
        // dp[1] 表示持有股票的最大利润
        int len = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}
