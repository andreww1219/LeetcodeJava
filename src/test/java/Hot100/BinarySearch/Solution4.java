package Hot100.BinarySearch;


// 寻找两个正序数组的中位数
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        return len % 2 == 1 ?
            findKthSmallestEle(nums1, nums2, len / 2 + 1) :
            (findKthSmallestEle(nums1, nums2, len / 2) + findKthSmallestEle(nums1, nums2, len / 2 + 1)) * 0.5;
    }
    private int findKthSmallestEle(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int left1 = 0, left2 = 0;
        while (true) {
            if (left1 == len1) return nums2[left2 + k - 1];
            if (left2 == len2) return nums1[left1 + k - 1];
            if (k == 1) return Math.min(nums1[left1], nums2[left2]);
            int half = k / 2;
            int mid1 = Math.min(left1 + half, len1) - 1;
            int mid2 = Math.min(left2 + half, len2) - 1;
            // 小的元素之前至多有k-2个元素
            if (nums1[mid1] < nums2[mid2]) {
                k -= (mid1 - left1 + 1);
                left1 = mid1 + 1;
            } else {
                k -= (mid2 - left2 + 1);
                left2 = mid2 + 1;
            }
        }
    }
}
