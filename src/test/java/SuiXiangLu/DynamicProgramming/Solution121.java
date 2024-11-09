package SuiXiangLu.DynamicProgramming;


// 买卖股票的最佳时机
public class Solution121 {
    // 贪心
    public int maxProfit1(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] - min > max) max = prices[i] - min;
        }
        return max;
    }
    // 动态规划
    public int maxProfit2(int[] prices) {
        // dp[i][0] 表示第 i 天不持有股票的最大利润
        // dp[i][1] 表示第 i 天持有股票的最大利润
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 卖掉
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);                  // 买便宜的
        }
        return dp[len - 1][0];
    }
}
