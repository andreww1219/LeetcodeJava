package Classic150.Matrix;

import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
public class Solution54 {
    private final int[] dirX = {0, 1, 0, -1};
    private final int[] dirY = {1, 0, -1, 0};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int x = 0, y = 0, total = rows * cols, dir = 0;
        for (int i = 0; i < total; ++i) {
            ans.add(matrix[x][y]);
            vis[x][y] = true;
            int tempX = x + dirX[dir], tempY = y + dirY[dir];
            if (tempX < 0 || tempX >= rows || tempY < 0 || tempY >= cols || vis[tempX][tempY]) {
                dir = (dir + 1) % 4;
                tempX = x + dirX[dir];
                tempY = y + dirY[dir];
            }
            x = tempX;
            y = tempY;
        }
        return ans;
    }
}
