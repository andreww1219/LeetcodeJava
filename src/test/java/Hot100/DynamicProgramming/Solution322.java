package Hot100.DynamicProgramming;


import java.util.Arrays;

// 零钱兑换
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int len = coins.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; ++i) {// 遍历物品
            for (int j = coins[i]; j <= amount; ++j) { // 遍历背包
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
