package Hot100.DynamicProgramming;


import org.junit.Test;

import java.util.Arrays;

// 最长递增子序列
public class Solution300 {
    // dp O(n^2)
    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];    // dp[i]表示0~i的最长递增子序列
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }
    // 贪心+二分
    @Test
    public void test() {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS2(arr));
    }
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        int[] tails = new int[len + 1];    // tails[i]表示长度为i+1的最长递增子序列的末尾元素
        tails[1] = nums[0];
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i] > tails[tail]) {
                tail++;
                tails[tail] = nums[i];
                continue;
            }
            // 利用二分找到tails中第一个小于nums[i]的元素，找不到则替换第一个元素
            int l = 1, r = tail, pos = 0;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (nums[i] > tails[mid]) {
                    pos = mid;
                    l = mid + 1;
                } else r = mid - 1;
            }
            tails[pos + 1] = nums[i];
        }
        return tail;
    }
}
