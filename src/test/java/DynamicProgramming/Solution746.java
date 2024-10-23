package DynamicProgramming;

import java.util.Arrays;
import java.util.Map;

// 使用最小花费爬楼梯
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        // f(x) = min(f(x - 1) + cost[x - 1], f(x - 2) + cost[x - 2])
        // 走到下标 i 的最小花费
        int[] min_cost = new int[cost.length + 1];
        min_cost[0] = min_cost[1] = 0;
        for (int i = 2; i <= cost.length; ++i) {
            min_cost[i] = Math.min(
                    min_cost[i - 1] + cost[i - 1],
                    min_cost[i - 2] + cost[i - 2]
            );
        }
        return min_cost[cost.length];
    }
}
