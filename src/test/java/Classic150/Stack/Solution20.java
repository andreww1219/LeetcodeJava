package Classic150.Stack;


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// 有效的括号
public class Solution20 {
    @Test
    public void test() {
        System.out.println(isValid("([])"));
    }
    private Map<Character, Character> map = new HashMap<>(){{
        put('}', '{');
        put(']', '[');
        put(')', '(');
    }};
    public boolean isValid(String s) {
        int len = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || map.get(ch) != stack.peek())
                    return false;
                stack.pop();
            } else stack.push(ch);
        }
        return stack.isEmpty();
    }
}
