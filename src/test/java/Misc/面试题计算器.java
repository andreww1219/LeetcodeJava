package Misc;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

// 面试题16.26计算器
public class 面试题计算器 {
    private static Map<Character, Integer> priority = new HashMap<>();
    static {
        priority.put('*', 1);
        priority.put('/', 1);
        priority.put('+', 0);
        priority.put('-', 0);
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
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        for (char ch: arr) {
            if (ch == ' ') continue;
            if (ch >= '0' && ch <= '9')
                numbers.push(ch - '0');
            else {
                if (!operators.isEmpty() &&
                        priority.get(ch) < priority.get(operators.peek())) {
                    int num2 = numbers.pop(), num1 = numbers.pop();
                    numbers.push(operation(num1, num2, operators.pop()));
                }
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) {
            int num2 = numbers.pop(), num1 = numbers.pop();
            numbers.push(operation(num1, num2, operators.pop()));
        }
        return numbers.peek();
    }
}
