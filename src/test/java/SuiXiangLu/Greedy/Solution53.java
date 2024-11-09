package SuiXiangLu.Greedy;


// 最大子数组和
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int l = 0, r = 0;
        long maxSum = Long.MIN_VALUE, curSum = 0;
        while (l < nums.length && r < nums.length) {
            curSum += nums[r];
            if (curSum > maxSum){
                maxSum = curSum;
            }
            if (curSum < 0) {
                r = r + 1;
                l = r;
                curSum = 0;
            } else {
                r++;
            }
        }
        return (int) maxSum;
    }
}
