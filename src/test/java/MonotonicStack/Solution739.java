package MonotonicStack;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// 每日温度
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }
        return res;
    }
}
