package SuiXiangLu.StackAndQueue;

import org.junit.Test;

import java.util.ArrayDeque;

public class Solution1047 {
    @Test
    public void test(){
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }
    public String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (deque.isEmpty() ||
                    (deque.getLast() != s.charAt(i)))
                deque.addLast(s.charAt(i));
            else if (deque.getLast() == s.charAt(i))
                deque.removeLast();
        }
        StringBuilder sb = new StringBuilder("");
        while (!deque.isEmpty())
            sb.append(deque.removeFirst());
        return sb.toString();
    }
}
