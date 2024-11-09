package SuiXiangLu.String;

// 找出字符串中第一个匹配项的下标
public class Solution28 {
    // kmp 算法
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
    public int strStr1(String haystack, String needle) {
        return find(haystack, needle, getNext(needle));
    }

    // java 自带的匹配函数
    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
