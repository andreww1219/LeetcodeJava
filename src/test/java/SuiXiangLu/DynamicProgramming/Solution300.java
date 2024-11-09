package SuiXiangLu.DynamicProgramming;

import java.util.Arrays;

// 最长递增子序列
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }
}
