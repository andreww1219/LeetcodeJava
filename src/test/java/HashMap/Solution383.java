package HashMap;


import java.util.HashMap;

// 赎金信
public class Solution383 {

    // 初见
    public boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len1 = ransomNote.length(), len2 = magazine.length();
        for (int i = 0; i < len2; ++i){
            Character ch = magazine.charAt(i);
            Integer cnt = map.get(ch);
            if (cnt == null)
                map.put(ch, 1);
            else
                map.put(ch, cnt + 1);
        }
        for (int i = 0; i < len1; ++i){
            Character ch = ransomNote.charAt(i);
            Integer cnt = map.get(ch);
            if (cnt == null)
                return false;
            else if (cnt == 1)
                map.remove(ch);
            else
                map.replace(ch, cnt - 1);
        }
        return true;
    }

    // 数组哈希（标准题解）
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (int i = 0; i < 26; ++i)
            record[i] = 0;
        int len1 = ransomNote.length(), len2 = magazine.length();
        for (int i = 0; i < len2; ++i)
            record[magazine.charAt(i) - 'a']++;
        for (int i = 0; i < len1; ++i)
            if (record[ransomNote.charAt(i) - 'a'] > 0)
                record[ransomNote.charAt(i) - 'a']--;
            else
                return false;
        return true;
    }
}
