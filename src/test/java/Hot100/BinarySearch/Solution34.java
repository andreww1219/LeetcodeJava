package Hot100.BinarySearch;

// 在排序数组中查找元素的第一个和最后一个位置
public class Solution34 {
    // 初见
    public int[] searchRange1(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        // 找到最后出现的位置
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) ans[1] = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (ans[1] == -1) return ans;
        // 找到第一个出现的位置
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) ans[0] = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
