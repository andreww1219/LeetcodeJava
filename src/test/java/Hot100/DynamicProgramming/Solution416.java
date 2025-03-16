package Hot100.DynamicProgramming;



// 分割等和子集
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < len; ++i) sum += nums[i];
        if (sum % 2 == 1) return false;
        int bagSize = sum / 2;
        boolean[] dp = new boolean[bagSize + 1];
        dp[0] = true;
        for (int i = 0; i < len; ++i) { // 遍历物品
            for (int j = bagSize; j >= nums[i]; j--) {  // 遍历背包
                dp[j] = dp[j - nums[i]] || dp[j];
            }
        }
        return dp[bagSize];
    }
}
