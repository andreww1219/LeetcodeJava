package Classic150.Stack;


import java.util.Deque;
import java.util.LinkedList;

// 基本计算器
public class Solution224 {
    public int calculate(String s) {
        int len = s.length();
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int i = 0, ans = 0, sign = 1;
        while (i < len) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += sign * num;
            } else {
                if (s.charAt(i) == '+')
                    sign = ops.peek();
                else if (s.charAt(i) == '-')
                    sign = -ops.peek();
                else if (s.charAt(i) == '(')
                    ops.push(sign);
                else if (s.charAt(i) == ')')
                    ops.pop();
                i++;    // s[i]为空格会略过
            }
        }
        return ans;
    }
}
