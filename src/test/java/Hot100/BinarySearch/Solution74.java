package Hot100.BinarySearch;


// 搜索二维矩阵
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 第一个小于等于target下标
        int l = 0, r = matrix.length - 1, row = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] <= target) {
                row = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 在第row行查找target
        l = 0;
        r = matrix[0].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}
