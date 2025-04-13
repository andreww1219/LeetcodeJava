package Classic150.Interval;


import java.util.Arrays;

// 用最少数量的箭引爆气球
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int len = points.length;
        int arrows = 1;
        int end = points[0][1];
        for (int i = 1; i < len; ++i) {
            if (points[i][0] > end) {
                // 无交集
                arrows++;
                end = points[i][1];
            } else {
                // 有交集
                end = Math.min(end, points[i][1]);
            }
        }
        return arrows;
    }
}
