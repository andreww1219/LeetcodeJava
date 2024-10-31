package DynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

// 最长重复子数组
public class Solution718 {
    @Test
    public void test() {
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 0};
        System.out.println(findLength1(nums1, nums2));
    }
    // 二维dp
    public int findLength1(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        // dp[i][j] 表示以 nums1[i] 和 nums2[j] 结尾的重复子数组长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化 dp 数组
        for (int i = 0; i <= len1; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= len2; i++)
            dp[0][i] = 0;
        // 遍历
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    // 滚动数组
    public int findLength2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        // dp[i][j] 表示以 nums1[i] 和 nums2[j] 结尾的重复子数组长度
        int[] dp = new int[len2 + 1];
        // 初始化 dp 数组
        Arrays.fill(dp, 0);
        // 遍历
        // 由于 dp[i][j] 由 dp[i - 1][j - 1]推导而出
        // 压缩为 dp[j] 由 do[j - 1]推到而出
        // 为了不覆盖 上一层的 dp[i - 1][j - 1], j 应该从后向前遍历
        int max = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = len2; j >= 1; j--) {
                dp[j] = nums1[i - 1] == nums2[j - 1] ? dp[j - 1] + 1 : 0;
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
