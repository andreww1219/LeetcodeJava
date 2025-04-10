package Classic150.ArrayAndString;

// 合并两个有序数组
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) res[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        while (i < m) res[k++] = nums1[i++];
        while (j < n) res[k++] = nums2[j++];
        for (int iter = 0; iter < m + n; ++iter) nums1[iter] = res[iter];
    }
}
