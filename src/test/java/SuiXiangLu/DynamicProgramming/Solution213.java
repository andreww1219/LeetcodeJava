package SuiXiangLu.DynamicProgramming;

// 打家劫舍II
public class Solution213 {
    int robRange(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return nums[start];
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; ++i) {
            dp[i - start] = Math.max(dp[i - start - 1], dp[i - start - 2] + nums[i]);
        }
        return dp[len - 1];
    }
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int result1 = robRange(nums, 0, len - 2);
        int result2 = robRange(nums, 1, len - 1);
        return Math.max(result1, result2);
    }
}
