package String;

import org.junit.Test;

import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 反转字符串中的单词
public class Solution151 {
    // 初见 速度吊车尾
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(s);
        List<String> words = new ArrayList<>();
        while (scanner.hasNext())
            words.add(scanner.next());
        sb.append(words.get(words.size() - 1));
        for (int i = words.size() - 2; i >= 0; --i)
            sb.append(" " + words.get(i));
        return sb.toString();
    }
    private StringBuilder reverse(StringBuilder sb, int start, int end){
        for (int l = start, r = end; l < r; l++, r--){
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
        }
        return sb;
    }
    private StringBuilder removeSpaces(StringBuilder s){
        int len = s.length();
        int start = 0, end = len - 1;
        while (s.charAt(start) == ' ')start++;
        while (s.charAt(end) == ' ')end--;

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; ++i){
            char ch = s.charAt(i);
            if (ch != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(ch);
        }
        return sb;
    }
    public String reverseWords2(String s) {
        // 反转字符串
        StringBuilder sb = reverse(new StringBuilder(s),
                0, s.length() - 1);
        // 去除多余空格
        sb = removeSpaces(sb);
        int len = sb.length();
        int l = 0;
        while (l < len) {
            int r = l;
            while (r < len && !Character.isSpaceChar(sb.charAt(r)))
                r++;
            sb = reverse(sb, l, r - 1);
            l = r + 1;
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(reverseWords2("the sky is blue"));
    }
}
