package Hot100.Matrix;

import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
public class Solution54 {
    int dir = 0;
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};
    private boolean check(boolean[][] vis, int m, int n, int i, int j) {
        return !(i < 0 || i >= m || j < 0 || j >= n || vis[i][j]);
    }
    public List<Integer> spiralOrder1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        int x = 0, y = 0, cnt = 0, total = m * n;
        List<Integer> res = new ArrayList<>();
        while (cnt < total) {
            vis[x][y] = true;
            res.add(matrix[x][y]);
            int tempX = x + dirX[dir], tempY = y + dirY[dir];
            if (!check(vis, m, n, tempX, tempY)) {
                dir = (dir + 1) % 4;
                x = x + dirX[dir];
                y = y + dirY[dir];
            } else {
                x = tempX;
                y = tempY;
            }
            cnt++;
        }
        return res;
    }
    // 绝美题解
    public List<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int l = 0, r = m - 1, u = 0, d = m - 1;
        while (true) {
            // 从左往右
            for (int j = l; j <= r; ++j)
               res.add(matrix[u][j]);
            if (++u > d) break;
            // 从上往下
            for (int i = u; i <= d; ++i)
                res.add(matrix[i][r]);
            if (--r < l) break;
            // 从右往左
            for (int j = r; j >= l; --j)
                res.add(matrix[d][j]);
            if (--d < u) break;
            // 从下往上
            for (int i = d; i >= u; --i)
                res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
