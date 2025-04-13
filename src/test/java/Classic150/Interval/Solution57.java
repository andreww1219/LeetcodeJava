package Classic150.Interval;


import java.util.ArrayList;
import java.util.List;

// 插入区间
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        for (int[] interval: intervals) {
            if (right < interval[0]) {
                // 与左边界无交集
                if (!placed) {
                    ans.add(new int[]{left, right});
                    placed = true;
                }
                ans.add(interval);
                placed = true;
            } else if (left > interval[1]) {
                // 与右边界无交集
                ans.add(interval);
            } else {
                // 有交集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        // 未被放置
        if (!placed) ans.add(new int[]{left, right});
        return ans.toArray(new int[ans.size()][2]);
    }
}
