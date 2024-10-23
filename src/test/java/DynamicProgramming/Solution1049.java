package DynamicProgramming;


import org.junit.Test;

// 最后一块石头的重量II
public class Solution1049 {
    @Test
    public void test() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
    }
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length, sum = 0;
        for (int num: stones) sum += num;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; ++i)
            for (int j = target; j >= stones[i]; --j)
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
        return sum - dp[target] - dp[target];
    }
}
