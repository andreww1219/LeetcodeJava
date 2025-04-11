package Classic150.ArrayAndString;


import org.junit.Test;

// 反转字符串中的单词
public class Solution151 {
    @Test
    public void test() {
        System.out.println(reverseWords("a good   example"));
    }
    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }
    public String reverseWords(String s) {
        // 截断前后空格
        StringBuilder sb = new StringBuilder();
        int last = s.length() - 1;
        while (last >= 0 && s.charAt(last) == ' ') last--;
        int start = 0;
        while (start <= last && s.charAt(start) == ' ') start++;
        for (int i = start; i <= last; ++i) sb.append(s.charAt(i));
        // 反转字符串后，反转其中的单词
        reverse(sb, 0, sb.length() - 1);
        int begin = 0, i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == ' ') {
                reverse(sb, begin, i - 1);
                while (i < sb.length() - 1 && sb.charAt(i + 1) == ' ')
                    sb.deleteCharAt(i);
                begin = i + 1;
            }
            i++;
        }
        reverse(sb, begin, sb.length() - 1);
        return sb.toString();
    }
}
