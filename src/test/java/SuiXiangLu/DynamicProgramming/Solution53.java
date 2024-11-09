package SuiXiangLu.DynamicProgramming;


// 最大子数组和
public class Solution53 {
    // 动态规划
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // 动态规划空间优化 贪心
    public int maxSubArray2(int[] nums) {
        int res = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }
}
