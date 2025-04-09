package Misc.PrefixSum;


// 统计「优美子数组」
public class Solution1248 {
    // 滑动窗口
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] record = new int[len + 1];
        record[0] = 1;
        int ans = 0, cnt = 0;
        for (int i = 0; i < len; ++i) {
            cnt += nums[i] % 2;
            ans += cnt - k >= 0 ? record[cnt - k] : 0;
            record[cnt] += 1;
        }
        return ans;
    }
}
