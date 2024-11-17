package Hot100.Array;


// 轮转数组
public class Solution189 {
    // 初见
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] temp = new int[k];
        for (int i = len - 1; i >= 0; --i) {
            if (i >= len - k)
                temp[i - len + k] = nums[i];
            if (i >= k)
                nums[i] = nums[i - k];
            else
                nums[i] = temp[i];
        }
    }
    // 数组翻转
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }
}
