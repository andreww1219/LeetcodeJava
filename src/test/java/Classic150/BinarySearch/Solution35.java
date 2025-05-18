package Classic150.BinarySearch;


// 搜索插入位置
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        // 找到第一个大于等于target的数的索引
        int len = nums.length;
        if (nums[len - 1] < target) return len;
        if (nums[0] >= target) return 0;
        int l = 0, r = len - 1, ans = len;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
