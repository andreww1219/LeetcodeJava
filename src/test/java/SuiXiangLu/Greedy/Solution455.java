package SuiXiangLu.Greedy;

import java.util.Arrays;

// 分发饼干
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int gIndex = 0, sIndex = 0;
        while (sIndex < s.length && gIndex < g.length) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
                sIndex++;
                cnt++;
            } else {
                sIndex++;
            }
        }
        return cnt;
    }
}
