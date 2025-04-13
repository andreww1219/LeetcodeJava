package Classic150.HashMap;


// 有效的字母异位词
public class Solution242 {
    private final int RANGE = 26;
    public boolean isAnagram(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) return false;
        int[] record = new int[RANGE];
        for (char ch: t.toCharArray()) record[ch - 'a']++;
        for (char ch: s.toCharArray()) {
            record[ch - 'a']--;
            if (record[ch - 'a'] < 0) return false;
        }
        return true;
    }
}
