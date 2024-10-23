package String;

import org.junit.Test;

import javax.management.ObjectName;

// 重复的子字符串
public class Solution459 {
    @Test
    public void test(){
        String STR = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern1(STR));
    }
    // 使用 kmp
    private int[] getNext(String str) {
        int len = str.length();
        int[] next = new int[len];
        next[0] = 0;
        for (int i = 1, j = 0; i < len; ++i) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = next[j - 1];
            if (str.charAt(j) == str.charAt(i))
                ++j;
            next[i] = j;
        }
        return next;
    }
    private int find(String text, String pattern, int[] next){
        int lenPattern = pattern.length(), lenText = text.length();
        for (int i = 0, j = 0; i < lenText; ++i){
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if (text.charAt(i) == pattern.charAt(j))
                ++j;
            if (j == lenPattern)
                return i - lenPattern + 1;
        }
        return -1;
    }
    public boolean repeatedSubstringPattern1(String s) {
        String combined = s + s;
        StringBuilder sb = new StringBuilder(combined);
        sb.replace(0, 1, "");
        sb.replace(sb.length() - 1, sb.length(), "");
        return find(sb.toString(), s, getNext(s)) != -1;
    }
    // 使用 java 自带方法
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != -1;
    }
}
