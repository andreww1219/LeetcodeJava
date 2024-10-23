package Greedy;


import java.util.Arrays;

// 无重叠区间
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[1], b[1]));
        int remove = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (end > intervals[i][0]) {
                // 重叠
                remove++;
            } else {
                // 不重叠
                end = intervals[i][1];
            }
        }
        return remove;
    }
}
