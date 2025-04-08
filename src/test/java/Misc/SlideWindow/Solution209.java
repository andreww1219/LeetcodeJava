package Misc.SlideWindow;

// 长度最小的子数组
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0, l = 0, r = 0, len = nums.length;
        while (r < len) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
