package Classic150.HashMap;


// 赎金信
public class Solution383 {
    private final int RANGE = 26;
    public boolean canConstruct(String ransomNote, String magazine) {
        // 初始化缺失的字符
        int[] record = new int[RANGE];
        int len1 = ransomNote.length(), len2 = magazine.length();
        for (int i = 0; i < len1; ++i) record[ransomNote.charAt(i) - 'a']--;
        int less = 0;
        for (int i = 0; i < RANGE; ++i) if (record[i] < 0) less++;
        // 遍历判断能否构成
        for (int i = 0; i < len2; ++i) {
            int offset = magazine.charAt(i) - 'a';
            record[offset]++;
            if (record[offset] == 0) less--;
            if (less == 0) return true;
        }
        return false;
    }
}
