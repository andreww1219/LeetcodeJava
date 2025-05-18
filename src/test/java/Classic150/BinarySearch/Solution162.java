package Classic150.BinarySearch;


// 寻找峰值
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        if (len == 2) return nums[0] > nums[1] ? 0 : 1;
        int l = 0, r = len - 1, ans = 0;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (getNum(nums, mid - 1) < getNum(nums, mid)
                && getNum(nums, mid) > getNum(nums, mid + 1)) {
                ans = mid;
                break;
            }
            if (getNum(nums, mid) < getNum(nums, mid + 1))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return ans;
    }
    private int getNum(int[] nums, int i) {
        if (i == -1 || i == nums.length) return Integer.MIN_VALUE;
        return nums[i];
    }
}
