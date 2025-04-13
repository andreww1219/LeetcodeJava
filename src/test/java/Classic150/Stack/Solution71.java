package Classic150.Stack;


import java.util.Deque;
import java.util.LinkedList;

// 简化路径
public class Solution71 {
    public String simplifyPath(String path) {
        int len = path.length();
        Deque<String> stack = new LinkedList<>();
        int start = 1, end = 1;
        while (end < len) {
            // 当前文件夹名称
            while (end < len && path.charAt(end) != '/') end++;
            String substr = path.substring(start, end);
            if ("..".equals(substr)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!".".equals(substr) && substr.length() > 0) stack.push(substr);
            // 下一个文件夹名称开头
            start = end + 1;
            end = start;
        }
        // 拼接路径
        StringBuilder sb = new StringBuilder("/");
        int size = stack.size();
        for (int i = 0; i < size; ++i) {
            sb.append(stack.pollLast());
            if (i < size - 1) sb.append("/");
        }
        return sb.toString();
    }
}
