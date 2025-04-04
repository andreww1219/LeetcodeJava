package Hot100.Trick;

import org.junit.Test;
// 下一个排列
public class Solution31 {
    @Test
    public void test() {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // 找到末尾第一个上升的下标
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            // 找到第一个大于nums[i]的数
            int j = len - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1);
    }
}
