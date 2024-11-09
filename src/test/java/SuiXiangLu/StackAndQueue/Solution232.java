package SuiXiangLu.StackAndQueue;

import java.util.Stack;

// 用栈实现队列
public class Solution232 {
    // 初见
    class MyQueue1 {
        Stack<Integer> input;
        Stack<Integer> output;
        public MyQueue1() {
            input = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            output = new Stack<>();
            while (!input.empty())
                output.push(input.pop());
            int result = output.pop();
            while (!output.empty())
                input.push(output.pop());
            return result;
        }

        public int peek() {
            output = new Stack<>();
            while (!input.empty())
                output.push(input.pop());
            int result = output.peek();
            while (!output.empty())
                input.push(output.pop());
            return result;
        }

        public boolean empty() {
            return input.empty();
        }
    }

    // 标准题解
    class MyQueue2 {
        Stack<Integer> input;
        Stack<Integer> output;
        public MyQueue2() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            dumpInput();
            return output.pop();
        }

        public int peek() {
            dumpInput();
            return output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
        private void dumpInput(){
            // 当 output 为空时，导入 input
            if (output.empty()){
                while (!input.empty())
                    output.push(input.pop());
            }
        }
    }
}
