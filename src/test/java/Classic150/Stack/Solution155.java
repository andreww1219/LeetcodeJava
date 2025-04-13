package Classic150.Stack;


import java.util.Deque;
import java.util.LinkedList;

// 最小栈
public class Solution155 {
    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;
        public MinStack() {
            // 维护每个元素入栈时的栈中最小值
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || minStack.peek() >= val)
                minStack.push(val);
        }
        public void pop() {
            Integer top = stack.pop();
            if (minStack.peek().equals(top))
                minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
