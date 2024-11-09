package SuiXiangLu.DynamicProgramming;

// 分割等和子集
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;
        for (int i = 0; i < len; ++i)
            sum += nums[i];

        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; ++i) {
            for (int j = target; j >= nums[i]; --j) {
                dp[j] = Math.max(dp[j],
                        dp[j - nums[i]] + nums[i]);
            }
            // 剪枝
            if (dp[target] == target) return true;
        }
        return dp[target] == target;
    }
}
