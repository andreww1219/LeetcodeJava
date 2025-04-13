package Classic150.Matrix;


import org.junit.Test;

// 旋转图像
public class Solution48 {
    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
    }
    private void rotatePartial(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int val = matrix[row][col];     // 保存左上
        matrix[row][col] = matrix[n - 1 - col][row];                 // 左上 = 左下
        matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col]; // 左下 = 右下
        matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row]; // 右下 = 右上
        matrix[col][n - 1 - row] = val;                              // 右上 = 左上
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                rotatePartial(matrix, i, j);
            }
        }
    }
}
