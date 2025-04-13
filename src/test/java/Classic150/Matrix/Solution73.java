package Classic150.Matrix;

// 矩阵置零
public class Solution73 {
    // 空间O(m+n)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rowVis = new boolean[m];
        boolean[] colVis = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    rowVis[i] = true;
                    colVis[j] = true;
                }
            }
        }
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rowVis[i] || colVis[j])
                    matrix[i][j] = 0;
    }
    // 空间O(1)
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 直接利用第0行第0列作为标记，预存第0行和第0列的结果
        boolean row0 = false, col0 = false;
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        // 遍历矩阵，标记
        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 根据标记情况置零
        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        // 设置第0行和第0列
        if (col0) for (int i = 0; i < m; ++i) matrix[i][0] = 0;
        if (row0) for (int j = 0; j < n; ++j) matrix[0][j] = 0;
    }
}
