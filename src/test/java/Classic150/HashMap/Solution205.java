package Classic150.HashMap;


import java.util.Arrays;

// 同构字符串
public class Solution205 {
    private final int RANGE = 129;
    private final char IMPOSSIBLE = RANGE - 1;
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[RANGE];
        boolean[] exist = new boolean[RANGE];
        Arrays.fill(map, IMPOSSIBLE);
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char chS = s.charAt(i), chT = t.charAt(i);
            if (exist[chT] && map[chS] != chT)
                return false;
            if (map[chS] == IMPOSSIBLE) {
                map[chS] = chT;
                exist[chT] = true;
            } else if (map[chS] != chT)
                return false;
        }
        return true;
    }
}
