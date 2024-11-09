package SuiXiangLu.DynamicProgramming;


import org.junit.Test;

// 零钱兑换II
public class Solution518 {
    @Test
    public void test() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }
    public int change(int amount, int[] coins) {
        // dp[j] 表示取到金额 j 的方案数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
