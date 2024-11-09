package SuiXiangLu.StackAndQueue;

import java.util.Stack;

// 有效的括号
public class Solution20 {
    private boolean isBracket(char ch){
        return ch == '{' || ch =='}'
                || ch == '(' || ch == ')'
                || ch == '[' || ch == ']';
    }
    // 初见
    public boolean isValid1(String s) {
        int len = s.length();
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            if (isBracket(ch))
                stack1.push(ch);
        }
        Stack<Character> stack2 = new Stack<>();
        while (!stack1.empty()){
            char ch = stack1.pop();
            if (ch =='}' || ch == ')' || ch == ']')
                stack2.push(ch);
            else {
                if (stack2.empty())
                    return false;
                char rightBracket = stack2.pop();
                if (!((ch == '{' && rightBracket == '}')
                        || (ch == '(' && rightBracket == ')')
                        || (ch == '[' && rightBracket == ']')))
                    return false;
            }
        }
        return stack2.empty();
    }

    // 标准题解
    public boolean isValid2(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '(')
                stack.push(')');
            else if (stack.empty() || stack.pop() != ch)
                return false;
        }
        return stack.empty();
    }

}
