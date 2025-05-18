package Classic150.BinarySearch;

// 搜索旋转排序数组
public class Solution33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[0]) {
                if (nums[0] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[len - 1])
                    l = mid + 1;
                else
                    r = mid - 1;
            }

        }
        return -1;
    }

}
