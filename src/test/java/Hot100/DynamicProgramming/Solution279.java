package Hot100.DynamicProgramming;


import org.junit.Test;

import java.util.Arrays;

// 完全平方数
public class Solution279 {
    @Test
    public void test(){
        System.out.println(numSquares(12));
    }
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= m; ++i) { //遍历物品
            for (int j = i * i; j <= n; ++j) {  // 遍历背包
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
