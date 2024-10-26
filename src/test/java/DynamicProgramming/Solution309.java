package DynamicProgramming;

import org.junit.Test;

// 买卖股票的最佳时机含冷冻期
public class Solution309 {
    @Test
    public void test() {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[]dp = new int[2];   // 0 未持, 1 持有
        boolean[] frozen = new boolean[len];    // frozen[i - 1] 表示下标 i 是否被冻结
        dp[1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            if (dp[1] + prices[i] > dp[0]) {
                // 卖出
                dp[0] = dp[1] + prices[i];
                frozen[i] = true;
            }
            if (!frozen[i - 1] && dp[0] - prices[i] > dp[1]) {
                // 买入
                dp[1] = dp[0] - prices[i];
            }
        }
        return dp[0];
    }
}
