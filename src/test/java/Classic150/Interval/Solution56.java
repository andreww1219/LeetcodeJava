package Classic150.Interval;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 合并区间
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < len; ++i) {
            if (end < intervals[i][0]) {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else end = Math.max(end, intervals[i][1]);
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}
