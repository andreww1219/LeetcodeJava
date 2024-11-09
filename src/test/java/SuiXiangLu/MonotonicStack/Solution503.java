package SuiXiangLu.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 下一个更大元素 II
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i < 2 * len; ++i) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek() % len]) {
                int top = stack.pop();
                res[top % len] = nums[i % len];
            }
            stack.push(i);
        }
        return res;
    }
}
