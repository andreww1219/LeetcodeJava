package Hot100.BinarySearch;


// 搜索旋转排序数组
public class Solution33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        // 找到突变点
        int l = 1, r = len - 1, cutPoint = 0;   // 从 1 开始
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[0] < nums[mid])
                l = mid + 1;
            else {
                cutPoint = mid;
                r = mid - 1;
            }
        }
        // 二分查找
        l = 0; r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midIndex = (mid + cutPoint) % len;
            if (nums[midIndex] == target) return midIndex;
            if (nums[midIndex] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
