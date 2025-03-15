package Hot100.Greedy;


// 买卖股票的最佳时机
public class Solution121 {
    // 贪心
    public int maxProfit1(int[] prices) {
        int ans = 0, min = Integer.MAX_VALUE;
        for (int num: prices) {
            min = Math.min(min, num);
            ans = Math.max(ans, num - min);
        }
        return ans;
    }
    // dp
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];   // dp[i][0]表示未持有 dp[i][1]表示持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[len - 1][0];
    }
    // dp空间优化
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int val0 = 0;
        int val1 = -prices[0];
        for (int i = 1; i < len; ++i) {
            val0 = Math.max(val0, val1 + prices[i]);
            val1 = Math.max(val1, - prices[i]);
        }
        return val0;
    }
}
