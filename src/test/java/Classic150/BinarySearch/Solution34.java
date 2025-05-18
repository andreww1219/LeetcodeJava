package Classic150.BinarySearch;

import java.util.Arrays;

// 在排序数组中查找元素的第一个和最后一个位置
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) {
                r = mid - 1;
                if (nums[mid] == target)
                    res[0] = mid;
            } else {
                l = mid + 1;
            }
        }
        if (res[0] == -1) return res;
        l = 0;
        r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) {
                l = mid + 1;
                if (nums[mid] == target)
                    res[1] = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
