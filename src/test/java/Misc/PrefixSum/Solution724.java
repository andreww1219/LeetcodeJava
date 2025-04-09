package Misc.PrefixSum;


// 寻找数组的中心下标
public class Solution724 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; ++i) sum += nums[i];
        int[] pre = new int[len + 1];
        for (int i = 1; i <= len; ++i)
            pre[i] = pre[i - 1] + nums[i - 1];
        for (int i = 1; i <= len; ++i) {
            if (pre[i - 1] == pre[len] - pre[i])
                return i - 1;
        }
        return -1;
    }
}
