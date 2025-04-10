package Classic150.ArrayAndString;


// 买卖股票的最佳时机II
public class Solution122 {
    // dp
    public int maxProfit1(int[] prices) {
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
    // 空间优化
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < len; ++i) {
            int tempDp0 = dp0, tempDp1 = dp1;
            dp0 = Math.max(tempDp0, tempDp1 + prices[i]);
            dp1 = Math.max(tempDp1, tempDp0 - prices[i]);
        }
        return dp0;
    }
}
