package Hot100.BinarySearch;


// 寻转旋转排序数组中的最小值
public class Solution153 {
    // 初见
    public int findMin1(int[] nums) {
        int min = 0;
        int l = 1, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[0] < nums[mid]) l = mid + 1;
            else { r = mid - 1; min = mid;}
        }
        return nums[min];
    }
    // 官方题解
    public int findMin2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int pivot = l + (r - l) / 2;
            if (nums[pivot] < nums[r]) r = pivot;
            else l = pivot + 1;
        }
        return nums[l];
    }
}
