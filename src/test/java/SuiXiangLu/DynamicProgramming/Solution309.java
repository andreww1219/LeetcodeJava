package SuiXiangLu.DynamicProgramming;

import org.junit.Test;

// 买卖股票的最佳时机含冷冻期
public class Solution309 {
    @Test
    public void test() {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit1(prices));
    }
    // 合并情况动态规划
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][2];   // 0 未持, 1 持有
        dp[1][1] = -prices[0];      // dp[i] 表示第 i 天未持有和持有的收益
        for (int i = 2; i <= len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            // 此处利用了 dp[i - 1][0] == dp[i - 2][0] 合并了冷冻期后一天买入和非冷冻期后一天买入的情况
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }
        return dp[len][0];
    }
    // 状态转移
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];   // 0 持有, 1 未持有当天未卖出, 2 未持有当天卖出
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; ++i) {
            // 持有可有两个情况得到；1. 前一天已持有  2. 前一天未卖出股票，今天未处于冰冻期，今天买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            // 未持有当天未卖出可有两种情况得到：1. 前一天也未持有未卖出  2. 前一天未持有已卖出，今天解冻
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            // 未持有当天卖出只有一种情况得到：前一天持有, 今天卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
