package Classic150.Heap;


// 数组中的第K个最大元素
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
    private int findKthLargest(int[] nums, int l, int r, int k) {
        int mid = partition(nums, l, r);
        int rightNum = r - mid + 1; // num of elems between [mid, r]
        if (rightNum == k) return nums[mid];
        if (rightNum > k) return findKthLargest(nums, mid + 1, r, k);
        else return findKthLargest(nums, l, mid - 1, k - rightNum);
    }
}
