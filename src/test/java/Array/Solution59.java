package Array;

// 螺旋矩阵II

import java.awt.event.ActionListener;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.TreeMap;

public class Solution59 {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {1, 0, -1, 0};

    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; ++i){
            Arrays.fill(vis[i], false);
        }
        int size = n * n;
        int x = 0, y = 0, dir = 0;
        for (int i = 1; i <= size; ++i){
            vis[x][y] = true;
            mat[x][y] = i;
            int tempX = x + dirX[dir], tempY = y + dirY[dir];
            if (tempX >= n || tempY >= n
                    || tempX < 0 || tempY < 0
                    || vis[tempX][tempY]){
                dir = (dir + 1) % 4;
            }
            x += dirX[dir];
            y += dirY[dir];
        }
        return mat;
    }
}
