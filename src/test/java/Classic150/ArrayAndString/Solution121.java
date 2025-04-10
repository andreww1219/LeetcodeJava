package Classic150.ArrayAndString;


import org.junit.Test;

// 买卖股票的最佳时机
public class Solution121 {
    @Test
    public void test () {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(nums));
    }

    // dp
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];   // dp[i][0] 表示未持有 dp[i][1] 表示持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    // 空间优化
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp0 = Math.max(dp1 + prices[i], dp0);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }
}
