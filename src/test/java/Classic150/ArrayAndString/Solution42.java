package Classic150.ArrayAndString;

import java.nio.file.Watchable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

// 接雨水
public class Solution42 {
    // 双指针
    public int trap1(int[] height) {
        int len = height.length;
        // 得到每根柱子左右最高的柱子
        int[] left = new int[len];
        for (int i = 1; i < len; ++i) left[i] = Math.max(left[i - 1], height[i - 1]);
        int[] right = new int[len];
        for (int i = len - 2; i >= 0; --i) right[i] = Math.max(right[i + 1], height[i + 1]);
        // 求装水体积
        int sum = 0;
        for (int i = 1; i < len - 1; ++i) {
            int water = Math.min(left[i], right[i]) - height[i];
            if (water > 0 ) sum += water;
        }
        return sum;
    }
    // 单调栈
    public int trap2(int[] height) {
        // 维护单调递减，找到每个节点上一个比自己大的节点
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0, len = height.length;
        for (int i = 0; i < len; ++i) {
            while (!deque.isEmpty() && height[deque.peekLast()] < height[i]) {
                int mid = deque.pollLast();
                if (!deque.isEmpty()) {
                    int top = deque.peekLast();
                    int h = Math.min(height[top], height[i]) - height[mid];
                    int w = i - top - 1;
                    sum += h * w;
                }
            }
            deque.add(i);
        }
        return sum;
    }
}
