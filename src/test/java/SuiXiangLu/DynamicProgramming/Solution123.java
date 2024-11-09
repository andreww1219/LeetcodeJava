package SuiXiangLu.DynamicProgramming;

// 买卖股票的最佳时机III
public class Solution123 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[5];
        // 0 未操作; 1 第一次买入; 2 第一次卖出; 3 第二次买入; 4 第二次卖出
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int price : prices) {
            dp[1] = Math.max(dp[1], dp[0] - price);
            dp[2] = Math.max(dp[2], dp[1] + price);
            dp[3] = Math.max(dp[3], dp[2] - price);
            dp[4] = Math.max(dp[4], dp[3] + price);
        }
        return dp[4];
    }
}
