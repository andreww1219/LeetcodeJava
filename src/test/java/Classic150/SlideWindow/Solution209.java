package Classic150.SlideWindow;


// 长度最小的子数组
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int l = 0, r = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        while (r < len) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
