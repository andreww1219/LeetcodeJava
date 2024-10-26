package Greedy;

// 买卖股票的最佳时机 II
public class Solution122 {
    // 贪心
    public int maxProfit(int[] prices) {
        int res = 0;
//        for (int i = 1; i < prices.length; ++i) {
//            if (prices[i] - prices[i - 1] >= 0)
//                res += prices[i] - prices[i - 1];
//        }
        for (int i = 1; i < prices.length; ++i) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
