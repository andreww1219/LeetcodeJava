package HashMap;

import org.junit.Test;

// 有效的字母异位词
public class Solution242 {
    @Test
    public void test(){
        String s ="anagram", t = "nagaram";
        System.out.println(isAnagram1(s, t));
    }
    private final int SIZE = 26;
    private final int LEN = 7 * 10000;
    // 初见
    public boolean isAnagram1(String s, String t) {
        int[] cnt1 = new int[SIZE];
        int[] cnt2 = new int[SIZE];
        char[] chars1 = new char[LEN];
        char[] chars2 = new char[LEN];
        s.getChars(0, s.length(), chars1, 0);
        t.getChars(0, t.length(), chars2, 0);

        for (char ch: chars1)
            if (ch != 0)
                cnt1[ch - 'a']++;
            else
                break;
        for (char ch: chars2)
            if (ch != 0)
                cnt2[ch - 'a']++;
            else
                break;

        for (int i = 0; i < SIZE; ++i){
            if (cnt1[i] != cnt2[i])
                return false;
        }
        return true;
    }

    // 标准题解

    public boolean isAnagram2(String s, String t) {
        int[] record = new int[SIZE];
        int len1 = s.length(), len2 = t.length();
        for (int i = 0; i< len1; ++i){
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i< len2; ++i){
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < SIZE; ++i)
            if (record[i] != 0)
                return false;
        return true;
    }
}
