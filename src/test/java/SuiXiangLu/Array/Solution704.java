package SuiXiangLu.Array;

import org.junit.Test;
import java.util.Arrays;
//  二分查找


public class Solution704 {
    @Test
    public void test() {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 5;
        search1(arr, target);
        Arrays.asList(arr).forEach(System.out::println);
    }

    // 左闭右闭
    public int search1(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {                // [l, r]
            int mid = l + (r - l) / 2;  // 防止溢出
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
    // 左闭右开
    public int search2(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len;
        while (l < r) {                 // [l, r)
            int mid = l + (r - l) / 2;  // 防止溢出
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                r = mid;
            else
                l = mid + 1;
        }
        return -1;
    }
}
