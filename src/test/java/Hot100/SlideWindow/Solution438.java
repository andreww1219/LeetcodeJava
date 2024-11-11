package Hot100.SlideWindow;


import java.util.*;

// 找到字符串中所有字母异位词
public class Solution438 {
    // 滑动窗口 O( lenP + (lenS - lenP) * Sigma)  Sigma 是可能的字符数量
    public List<Integer> findAnagrams1(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        // 初始化
        int[] recordP = new int[26];
        char[] arrP = p.toCharArray();
        for (char ch: arrP) recordP[ch - 'a']++;

        // 滑动窗口中匹配
        int[] recordS = new int[26];
        char[] arrS = s.toCharArray();
        int lenS = arrS.length, lenP = arrP.length;
        int l = 0, r = 0;
        while (r < lenP - 1) recordS[arrS[r++] - 'a']++;
        List<Integer> res = new ArrayList<>();
        while (r < lenS) {
            recordS[arrS[r++] - 'a']++;
            if (Arrays.equals(recordS, recordP))
                res.add(l);
            recordS[arrS[l++] - 'a']--;
        }
        return res;
    }
    // 滑动窗口标准题解
    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        // 初始化
        int[] recordP = new int[26];
        int[] recordS = new int[26];
        char[] arrP = p.toCharArray();
        char[] arrS = s.toCharArray();
        int lenS = arrS.length, lenP = arrP.length;
        for (int i = 0; i < lenP; ++i) {
            recordP[arrP[i] - 'a']++;
            recordS[arrS[i] - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(recordS, recordP)) res.add(0);
        // 移动窗口
        for (int i = lenP; i < lenS; ++i) {
            recordS[arrS[i - lenP] - 'a']--;
            recordS[arrS[i] - 'a']++;
            if (Arrays.equals(recordS, recordP)) res.add(i - lenP + 1);
        }
        return res;
    }
    // 滑动窗口优化版 复杂度 O(lenP + Sigma + lenS)
    public List<Integer> findAnagrams3(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        // 初始化 O(lenP)
        int[] record = new int[26];
        char[] arrP = p.toCharArray();
        char[] arrS = s.toCharArray();
        int lenS = arrS.length, lenP = arrP.length;
        for (int i = 0; i < lenP; ++i) {
            record[arrP[i] - 'a']--;
            record[arrS[i] - 'a']++;
        }
        // 判断最前面的字符串是否是异位词 O(Sigma)
        int dif = 0;
        for (int i = 0; i < 26; ++i)
            if (record[i] != 0) dif++;
        List<Integer> res = new ArrayList<>();
        if (dif == 0) res.add(0);
        // 移动窗口
        for (int i = lenP; i < lenS; ++i) {
            // 加入右边的字符
            int r = arrS[i] - 'a';
            if (record[r] == -1) dif--;
            if (record[r] == 0) dif++;
            record[r]++;
            // 移除左边的字符
            int l = arrS[i - lenP] - 'a';
            if (record[l] == 1) dif--;
            if (record[l] == 0) dif++;
            record[l]--;

            if (dif == 0) res.add(i - lenP + 1);
        }
        return res;
    }
}
