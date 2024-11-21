package Hot100.Matrix;


import org.junit.Test;

// 搜索二维矩阵II
public class Solution240 {
    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25}};
        int target = 19;
        System.out.println(searchMatrix1(matrix, target));
    }
    // 初见 二分 通过 107/130
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 确定在第几列
        int l = 0, r = n - 1, mid = l + (r - l) / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((mid == n - 1 && target >= matrix[0][mid])
                || (target >= matrix[0][mid] && target < matrix[0][mid + 1]))
                break;
            if (target < matrix[0][mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        // 确定在第几行
        int col = mid;
        l = 0;
        r = m - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (target == matrix[mid][col])
                return true;
            if (target < matrix[mid][col])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
    // 线性 + 二分 O(mlogn)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 确定在哪几列
        int colL = 0, colR = n - 1;
        while (colR >= 0 && target < matrix[0][colR])
            colR--;
        while (colL < n && target > matrix[m - 1][colL])
            colL++;
        // 确定在第几行
        for (int i = colL; i <= colR; i++) {
            int rowL = 0, rowR = m - 1;
            while (rowL <= rowR) {
                int mid = rowL + (rowR - rowL) / 2;
                if (target == matrix[mid][i]) return true;
                if (target < matrix[mid][i]) rowR = mid - 1;
                else rowL = mid + 1;
            }
        }
        return false;
    }
    // Z字 O(m + n)
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (target == matrix[x][y]) return true;
            if (target > matrix[x][y]) x++;
            else y--;
        }
        return false;
    }
}
