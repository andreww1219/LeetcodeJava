package SuiXiangLu.Greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 合并区间
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] > end) {
                // 左边界大于最大右边界
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                // 重叠
                end = Math.max(end, intervals[i][1]);
            }
        }
        // 最后一个区间
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
