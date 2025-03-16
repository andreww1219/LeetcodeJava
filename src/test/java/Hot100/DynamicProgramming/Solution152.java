package Hot100.DynamicProgramming;


// 乘积最大子数组
public class Solution152 {
    public int maxProduct1(int[] nums) {
        int len = nums.length;
        long[] min = new long[len];   // min[i]表示以i为结尾乘积最小
        long[] max = new long[len];   // max[i]表示以i为结尾乘积最大
        min[0] = nums[0];
        max[0] = nums[0];
        long result = nums[0];
        for (int i = 1; i < len; ++i) {
            min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]));
            result = Math.max(result, max[i]);
        }
        return (int)result;
    }
    // 空间优化
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        long min = nums[0];
        long max = nums[0];
        long result = nums[0];
        for (int i = 1; i < len; ++i) {
            long tempMin = min, tempMax = max;
            min = Math.min(nums[i], Math.min(tempMin * nums[i], tempMax * nums[i]));
            max = Math.max(nums[i], Math.max(tempMin * nums[i], tempMax * nums[i]));
            result = Math.max(result, max);
        }
        return (int)result;
    }
}
