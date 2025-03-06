package Hot100.Stack;


import java.util.Deque;
import java.util.LinkedList;

// 柱状图中的最大矩形
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] arr = new int[len + 2];
        for (int i = 0; i < len; i++) arr[i + 1] = heights[i];
        // 维护一个单调递增序列，遇到下降就结算
        Deque<Integer> deq = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!deq.isEmpty() && arr[deq.peek()] > arr[i]) {
                int mid = deq.pop();
                if (!deq.isEmpty()) {
                    int h = arr[mid];
                    int w = i - deq.peek() - 1;
                    ans = Math.max(ans, h * w);
                }
            }
            deq.push(i);
        }
        return ans;
    }
}
