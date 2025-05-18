package Classic150.BinarySearch;


// 寻找两个正序数组的中位数
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        return len % 2 == 0 ? (findMedianSortedArrays(nums1, nums2, len / 2)
                + findMedianSortedArrays(nums1, nums2, len / 2 + 1)) / 2
                : findMedianSortedArrays(nums1, nums2, len / 2 + 1);
    }
    private double findMedianSortedArrays(int[] nums1, int[] nums2, int k) {
        int l1 = 0, l2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        while (true) {
            if (l1 == len1) return nums2[l2 + k - 1];
            if (l2 == len2) return nums1[l1 + k - 1];
            if (k == 1) return Math.min(nums1[l1], nums2[l2]);
            int half = k / 2;
            int mid1 = Math.min(l1 + half, len1) - 1;
            int mid2 = Math.min(l2 + half, len2) - 1;
            if (nums1[mid1] < nums2[mid2]) {
                k -= mid1 - l1 + 1;
                l1 = mid1 + 1;
            } else {
                k -= mid2 - l2 + 1;
                l2 = mid2 + 1;
            }
        }
    }
}
