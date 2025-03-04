package Hot100.Stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 有效的括号
public class Solution20 {
    // 初见
    private boolean close(char left, char right) {
        return (left == '{' && right == '}')
                || (left == '(' && right == ')')
                || (left == '[' && right == ']');
    }
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (!stack.isEmpty() && close(stack.peek(), chars[i]))
                stack.pop();
            else
                stack.push(chars[i]);
        }
        return stack.isEmpty();
    }
    // 官方题解，使用哈希表映射，右括号不匹配直接终止
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (map.containsKey(chars[i])) {
                // 如果是右括号
                if (stack.isEmpty() || map.get(chars[i]) != stack.peek())
                    return false;
                stack.pop();
            } else stack.push(chars[i]);
        }
        return stack.isEmpty();
    }
}
