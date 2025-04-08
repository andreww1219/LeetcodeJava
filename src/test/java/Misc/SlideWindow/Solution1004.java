package Misc.SlideWindow;

// 最大连续1的个数III
public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        // 等价于找到最长的"0的个数<=k"的区间
        int res = 0;
        int l = 0, r = 0, len = nums.length;
        int sum = 0;
        while (r < len) {
            sum += 1 - nums[r];
            while (sum > k)
                sum -= 1 - nums[l++];
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
