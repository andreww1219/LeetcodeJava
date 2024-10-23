package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

// 用队列实现栈
public class Solution225 {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // 每次添加新元素，都将新元素置于队头
            queue.add(x);
            int size = queue.size();
            while (--size > 0)
                queue.add(queue.poll());
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
