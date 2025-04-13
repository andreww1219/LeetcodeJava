package Classic150.SlideWindow;



// 无重复字符的最长子串
public class Solution3 {
    private final int RANGE = 128;
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int l = 0, r = 0, ans = 0;
        int[] record = new int[RANGE];
        while (r < len) {
            char chR = s.charAt(r);
            while (record[chR] > 0) {
                char chL = s.charAt(l++);
                record[chL]--;
            }
            record[chR]++;
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
