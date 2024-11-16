package Hot100.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// 合并区间
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[1], b[1]));
        int len = intervals.length;
        int start = intervals[len - 1][0], end = intervals[len - 1][1];
        List<int[]> res = new ArrayList<>();
        for (int i = len - 2; i >= 0; --i) {
            if (intervals[i][1] >= start)
                start = Math.min(start, intervals[i][0]);
            else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 最后一个
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][2]);
    }
}
