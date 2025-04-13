package Classic150.HashMap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 单词规律
public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> exist = new HashSet<>();
        if (pattern.length() != words.length) return false;
        int len = pattern.length();
        for (int i = 0; i < len; ++i) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (exist.contains(word) && !map.containsKey(ch))
                return false;
            if (!map.containsKey(ch)) {
                map.put(ch, word);
                exist.add(word);
            } else if (!map.get(ch).equals(word))
                return false;
        }
        return true;
    }
}
