package SuiXiangLu.DynamicProgramming;

// 买卖股票的最佳时期含手续费
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[] dp = new int[2];  // 0 未持有, 1 持有
        dp[1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}
