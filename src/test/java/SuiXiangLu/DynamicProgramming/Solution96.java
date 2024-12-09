package SuiXiangLu.DynamicProgramming;


import org.junit.Test;

// 不同的二叉搜索树
public class Solution96 {
    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                // 以 j 为头节点的二叉搜索树数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
