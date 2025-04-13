package Classic150.SlideWindow;


import org.junit.Test;

// 最小覆盖子串
public class Solution76 {
    @Test
    public void test() {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
    private final int RANGE = 128;
    public String minWindow(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS < lenT) return new String();
        char[] arrT = t.toCharArray();
        // 初始化record
        int[] record = new int[RANGE];
        int less = 0;
        for (char ch: arrT) {
            if (record[ch] == 0) less++;
            record[ch]--;
        }
        // 滑动窗口
        int ansL = -1, ansR = lenS;
        int l = 0, r = 0;
        while (r < lenS) {
            // 添加右边界字符
            char chR = s.charAt(r);
            record[chR]++;
            if (record[chR] == 0)
                less--;
            // 移除左边界字符
            while (less == 0) {
                // 找到最小全覆盖的边界
                if (ansR - ansL > r - l) {
                    ansL = l;
                    ansR = r;
                }
                // 移除前判断是否影响覆盖情况
                char chL = s.charAt(l);
                if (record[chL] == 0)
                    less++;
                record[chL]--;
                l++;

            }
            r++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }
}
