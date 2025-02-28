package Hot100.GraphTheory;


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 腐烂的橘子
public class Solution994 {
    @Test
    public void test() {
        int[][] grid = {{2, 2, 2, 1, 1}};
        System.out.println(orangesRotting2(grid));
    }
    // 初见

    public int orangesRotting1(int[][] grid) {
        // 状态 3 表示当前轮次被污染的橘子
        int count = 0;
        for (int i = 0; i <= grid.length * grid[0].length; ++i) {
            if (allPolluted(grid)) return count;
            pollute(grid);
            confirm(grid);
            count++;
        }
        return -1;
    }
    private boolean allPolluted(int[][] grid) {
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 1) return false;
        return true;
    }
    private void pollute(int[][] grid) {
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 2) continue;
                if (i + 1 < grid.length && grid[i + 1][j] == 1)
                    grid[i + 1][j] = 3;
                if (i - 1 >= 0 && grid[i - 1][j] == 1)
                    grid[i - 1][j] = 3;
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
                    grid[i][j + 1] = 3;
                if (j - 1 >= 0 && grid[i][j - 1] == 1)
                    grid[i][j - 1] = 3;
            }
        }
    }
    private void confirm(int[][] grid) {
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                if (grid[i][j] == 3) grid[i][j] = 2;
    }
    // 官解，多源广搜
    int[] dir_x = {0, 1, 0, -1};
    int[] dir_y = {1, 0, -1, 0};
    public int orangesRotting2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Map<Integer, Integer> badTime = new HashMap<>();  // 橘子坏的时间
        Queue<Integer> badOranges = new LinkedList<>(); // 坏橘子的位置
        int cnt = 0;    //需要感染的橘子个数
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 2) {
                    int badOne = i * cols + j;
                    badOranges.add(badOne);
                    badTime.put(badOne, 0);
                }
            }
        }
        // 开始感染
        int ans = 0;
        while (!badOranges.isEmpty()) {
            int badOne = badOranges.poll();
            int r = badOne / cols, c = badOne % cols;
            for (int i = 0; i < 4; ++i) {
                int x = r + dir_x[i], y = c + dir_y[i];
                if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    int curOne = x * cols + y;
                    ans = badTime.get(badOne) + 1;
                    badTime.put(curOne, ans);
                    badOranges.add(curOne);
                }
            }
        }
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                if (grid[i][j] == 1) return -1;
        return ans;
    }
}
