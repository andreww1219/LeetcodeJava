package Hot100.Matrix;


// 矩阵置零
public class Solution73 {
    // 标准题解1 使用两个标记数组
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0)
                    rows[i] = cols[j] = true;
            }
        }
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j) {
                if (rows[i] || cols[j])
                    matrix[i][j] = 0;
            }
        }
    }
    // 标准题解2 使用两个标记变量，只需要O(1)空间
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 利用第一行和第一列作为标记数组，在此之前，需要记录第一行和第一列是否需要置零
        boolean flag_col0 = false, flag_row0 = false;
        for (int i = 0; i < m; ++i) if (matrix[i][0] == 0) flag_col0 = true;
        for (int j = 0; j < n; ++j) if (matrix[0][j] == 0) flag_row0 = true;
        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        if (flag_col0) for (int i = 0; i < m; ++i) matrix[i][0] = 0;
        if (flag_row0) for (int j = 0; j < n; ++j) matrix[0][j] = 0;
    }
}
