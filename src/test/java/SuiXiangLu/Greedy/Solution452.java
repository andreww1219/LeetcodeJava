package SuiXiangLu.Greedy;


import java.util.Arrays;

// 用最少数量的箭引爆气球
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        // 按结束位置升序排序
        Arrays.sort(points, (a, b)->Integer.compare(a[1], b[1]));
        int end = points[0][1];
        int cnt = 1;
        for (int i = 1; i < points.length; ++i) {
            // end 表示当前箭可以击破的最右边界
            if (points[i][0] > end) {
                ++cnt;
                end = points[i][1];
            }
        }
        return cnt;
    }
}
