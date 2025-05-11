package Classic150.Kadane;


// 最大子数组和
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int globalMax = nums[0], curMax = nums[0];
        for (int i = 1; i < len; ++i) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}
