package SuiXiangLu.MonotonicStack;


import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

// 接雨水
public class Solution42 {
    @Test
    public void test() {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap1(height));
    }
    // 通过 146 / 323
    public int trap1(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (!stack.isEmpty() && height[stack.peek()] > height[top]) {
                    sum += (i - top) * (height[stack.peek()] - height[top]);
                }
            }
            stack.push(i);
        }
        return sum;
    }
    // 标准题解
    public int trap2(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - height[top];
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
