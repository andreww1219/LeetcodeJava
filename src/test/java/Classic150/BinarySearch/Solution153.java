package Classic150.BinarySearch;

// 寻找旋转排序数组中的最小值
public class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] <= nums[len - 1]) return nums[0];
        int l = 1, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[mid] >= nums[0])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
