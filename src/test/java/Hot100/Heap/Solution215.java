package Hot100.Heap;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 数组中的第K个最大元素
public class Solution215 {
    @Test
    public void test() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
    // 快排
    private int quickSort1(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int l = start, r = end;
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        int greaterNum = end - l;   // 比 pivot 大的数的数量
        if (greaterNum == k - 1) return pivot;
        if (greaterNum > k - 1) return quickSort1(nums, l + 1, end, k);
        else return quickSort1(nums, start, l - 1, k - greaterNum - 1);
    }
    // 三路快排
    private int quickSort2(List<Integer> nums, int k) {
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));
        List<Integer> equal = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int num: nums) {
            if (num > pivot) greater.add(num);
            else if (num < pivot) smaller.add(num);
            else equal.add(num);
        }
        if (greater.size() >= k) return quickSort2(greater, k);
        else if (equal.size() + greater.size() < k) return quickSort2(smaller, k - (equal.size() + greater.size()));
        return pivot;
    }
    public int findKthLargest(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);
        return quickSort2(arr, k);
    }
}
