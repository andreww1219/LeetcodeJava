package SuiXiangLu.DynamicProgramming;


// 目标和
public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (target > sum || (sum - target) % 2 != 0) return 0;
        int halfOfMinusTarget = (sum - target) / 2;
        // dp[i][j] 表示使用前 i 个数字可以达到目标和为 j 的方案数量
        // 使用滚动数组可简化到一维
        int[] dp = new int[halfOfMinusTarget + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = halfOfMinusTarget; j >= nums[i]; --j){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[halfOfMinusTarget];
    }
}
