package Classic150.ArrayAndString;


// 找出字符串中第一个匹配项的下标
public class Solution28 {
    private int[] getNext(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];  // [0, i]最长公共前后缀长度
        next[0] = 0;
        for (int i = 0, j = 0; i < len; ++i) {
            while (j != 0 && pattern.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }
    private int match(String str, String pattern, int[] next) {
        int len1 = str.length(), len2 = pattern.length();
        for (int i = 0, j = 0; i < len1; ++i) {
            while (j != 0 && str.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if (str.charAt(i) == pattern.charAt(j))
                j++;
            if (j == len2)
                return i - len2 + 1;
        }
        return -1;
    }
    public int strStr(String haystack, String needle) {
        return match(haystack, needle, getNext(needle));
    }
}
