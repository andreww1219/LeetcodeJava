package Hot100.Array;


import java.util.Map;

// 最大子数组和
public class Solution53 {
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        int r = 0, cur = 0;
        while (r < len) {
            cur += nums[r];
            res = Math.max(res, cur);
            if (cur < 0)
                cur = 0;
            r++;
        }
        return res;
    }
    // 标准题解 动态规划
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < len; ++i) {
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }
}
