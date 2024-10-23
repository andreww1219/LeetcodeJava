package Greedy;

// 摆动序列
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        // 只需计算波峰波谷
        int pre = 0, cur = 0, cnt = 1;
        for (int i = 1; i < nums.length; ++i) {
            cur = nums[i] - nums[i - 1];
            if ((pre >= 0 && cur < 0) || (pre <= 0 && cur > 0)) {
                ++cnt;
                pre = cur;
            }
        }
        return cnt;
    }
}
