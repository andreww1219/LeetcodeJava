package SuiXiangLu.DynamicProgramming;


// 买卖股票的最佳时机IV
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2 * k + 1];
        // dp[2 * i + 1] 表示第 i + 1 次买入
        // dp[2 * i + 2] 表示第 i + 1 次卖出
        for (int i = 0; i < k; ++i)
            dp[2 * i + 1] = -prices[0];
        for (int price: prices) {
            for (int i = 0; i < k; ++i) {
                dp[2 * i + 1] = Math.max(dp[2 * i + 1], dp[2 * i] - price);
                dp[2 * i + 2] = Math.max(dp[2 * i + 2], dp[2 * i + 1] + price);
            }
        }
        return dp[2 * k];
    }
}
