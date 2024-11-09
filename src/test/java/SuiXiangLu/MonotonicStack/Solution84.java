package SuiXiangLu.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

// 柱状图中最大的矩形
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] heightsExtended = new int[len + 2];
        for (int i = 1; i <= len; ++i)
            heightsExtended[i] = heights[i - 1];
        // 本题与接雨水相反
        // 接雨水需要维护【单调递减】的序列，以便在【遇到高的柱子】时，找到【前一个比自己高的柱子的下标】
        // 而这道题需要维护【单调递增】的序列，以便在【遇到低的柱子】时，找到【前一个比自己低的柱子的下标】
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len + 2; ++i) {
            while (!stack.isEmpty() && heightsExtended[stack.peek()] > heightsExtended[i]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int h = heightsExtended[mid];
                    res = Math.max(res, h * w);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
