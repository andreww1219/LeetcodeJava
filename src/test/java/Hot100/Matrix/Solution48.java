package Hot100.Matrix;


// 旋转图像
public class Solution48 {
    // 初见 翻转代替旋转
    private void reverse(int[] arr, int n) {
        for (int l = 0, r = n - 1; l < r; l++, r--){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
    }
    private void transpose(int[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i)
            reverse(matrix[i], n);
        transpose(matrix, n);
    }
    // 标准题解 分块原地旋转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int temp = matrix[i][j];                // 左上
                matrix[i][j] = matrix[n - j - 1][i];    // 左上 = 左下
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]; // 左下 = 右下
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]; // 右下 = 右上
                matrix[j][n - i - 1] = temp;            // 右上 = 左上

            }
        }
    }
}
