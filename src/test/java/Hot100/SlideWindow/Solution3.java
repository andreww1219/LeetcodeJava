package Hot100.SlideWindow;

import java.util.HashSet;
import java.util.Set;

// 无重复字符的最长子串
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0, r = 0, len = s.length();
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        while (r < len) {
            while (set.contains(arr[r])) {
                set.remove(arr[l]);
                l++;
            }
            set.add(arr[r]);
            r++;
            res = Math.max(res, r - l);
        }
        return res;
    }
}
