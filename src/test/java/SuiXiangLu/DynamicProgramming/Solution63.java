package SuiXiangLu.DynamicProgramming;


import org.junit.Test;

// 不同路径II
public class Solution63 {
    @Test
    public void test() {
        int[][] arr = {
                {0, 1},
                {0, 0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        int initVal = 1;
        for (int i = 0; i < rows; ++i) {
            if (obstacleGrid[i][0] == 1) initVal = 0;
            dp[i][0] = initVal;
        }
        initVal = 1;
        for (int j = 0; j < cols; ++j) {
            if (obstacleGrid[0][j] == 1) initVal = 0;
            dp[0][j] = initVal;
        }
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0;
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
