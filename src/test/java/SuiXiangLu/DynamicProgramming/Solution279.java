package SuiXiangLu.DynamicProgramming;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 完全平方数
public class Solution279 {
    // 初见
    public int numSquares1(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            list.add(i * i);
            ++i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (i = 0; i < list.size(); ++i) {
            int num = list.get(i);
            for (int j = num; j <= n; ++j) {
                if (dp[j - num] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? 0 : dp[n];
    }
    // 标准题解
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; ++i) {
            for (int j = i * i; j <= n; ++j) {
                int i_square = i * i;
                if (dp[j - i_square] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - i_square] + 1);
            }
        }
        return dp[n];
    }
}
