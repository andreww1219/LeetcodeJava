package Classic150.Kadane;


// 环形子数组的最大和
public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int max = nums[0], curMax = nums[0];
        int min = nums[0], curMin = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; ++i) {
            sum += nums[i];
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + nums[i], nums[i]);
            min = Math.min(min, curMin);
        }
        return max < 0 ? max : Math.max(max, sum - min);
    }
}
