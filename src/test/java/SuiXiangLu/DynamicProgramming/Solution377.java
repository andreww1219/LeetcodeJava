package SuiXiangLu.DynamicProgramming;

import org.junit.Test;

// 组合总和IV
public class Solution377 {
    // 回溯 通过样例 10/16 TLE
    int cnt = 0;
    void backtrace(int[] nums, int target, int sum) {
        if (sum > target) return;
        if (sum == target) {
            cnt++;
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            backtrace(nums, target, sum);
            sum -= nums[i];
        }
    }
    public int combinationSum4_1(int[] nums, int target) {
        backtrace(nums, target, 0);
        return cnt;
    }
    // 动态规划
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4_2(nums, target));
    }
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 全排列，先遍历背包容量，再遍历物品，可保证物品不按特定顺序
        for (int j = 1; j <= target; ++j) {
            for (int i = 0; i < nums.length; ++i) {
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
