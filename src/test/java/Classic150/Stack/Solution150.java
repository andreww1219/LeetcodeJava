package Classic150.Stack;


import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

// 逆波兰式表达式求值
public class Solution150 {
    @Test
    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    private int operation(int num1, int num2, char op) {
        switch (op) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            default: return 0;
        }
    }
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            if (tokens[i].length() == 1 && isOperator(tokens[i].charAt(0))) {
                int num2 = stack.pop(), num1 = stack.pop();
                stack.push(operation(num1, num2, tokens[i].charAt(0)));
            } else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }
}
