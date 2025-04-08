package Misc.SlideWindow;

// 尽可能使字符串相等
public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];
        for (int i = 0; i < len; ++i) cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        int l = 0, r = 0, sum = 0;
        int res = 0;
        // 找到sum <= maxCost的最长序列
        while (r < len) {
            sum += cost[r];
            while (sum > maxCost)
                sum -= cost[l++];
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
