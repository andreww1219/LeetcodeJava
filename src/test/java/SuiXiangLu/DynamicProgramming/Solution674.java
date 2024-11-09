package SuiXiangLu.DynamicProgramming;

// 最长连续递增序列
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int cur = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] > nums[i - 1] ? cur + 1 : 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
