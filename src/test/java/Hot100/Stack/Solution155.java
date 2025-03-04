package Hot100.Stack;

import java.util.Stack;

// 最小栈
public class Solution155 {
    // 初见，使用链表，插入删除O(N)，取最小值O(1)
    class MinStack1 {
        class Node {
            Node next;
            int val;
            public Node(int val) {this.val = val;}
            public Node(Node next) {this.next = next;}
        }
        Node head;  // 升序链表，head.next存放最小的元素
        Stack<Node> stack;
        public MinStack1() {
            stack = new Stack<>();
            head = new Node(null);
        }

        public void push(int val) {
            Node node = new Node(val);
            stack.push(node);
            insert(node);
        }

        public void pop() {
            Node node = stack.peek();
            stack.pop();
            delete(node);
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return head.next != null ? head.next.val : -1;
        }
        private void insert(Node node) {
            Node cur = head;
            while (cur.next != null && cur.next.val < node.val)
                cur = cur.next;
            node.next = cur.next;
            cur.next = node;
        }
        private void delete(Node node) {
            Node cur = head;
            while (cur.next != node)
                cur = cur.next;
            cur.next = node.next;
        }
    }

    // 官方题解，使用辅助栈，插入删除取最小值均O(1)
    class MinStack2 {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public MinStack2() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
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
