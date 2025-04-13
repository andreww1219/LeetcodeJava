package Classic150.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 字母异位词分组
public class Solution49 {
    // 字符+出现次数拼接作为哈希表的键，时间超越25%
    private final int RANGE = 26;
    public List<List<String>> groupAnagrams1(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            // 根据字母出现次数得到key
            char[] str = strs[i].toCharArray();
            int[] record = new int[RANGE];
            for (char ch: str) record[ch - 'a']++;
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < RANGE; ++j) {
                if (record[j] != 0) {
                    key.append((char)('a' + j));
                    key.append(record[j]);
                }
            }
            // 将字母异位词放到同一个List
            String keyStr = key.toString();
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    // long作为哈希表的键，时间超越98%
    private final int UPPERBOUND = 100;
    public List<List<String>> groupAnagrams2(String[] strs) {
        int len = strs.length;
        Map<Long, List<String>> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            // 根据字母出现次数得到key
            char[] str = strs[i].toCharArray();
            int[] record = new int[RANGE];
            for (char ch: str) record[ch - 'a']++;
            long key = 0;
            for (int j = 0; j < RANGE; ++j)
                key = key * UPPERBOUND + record[j];
            // 将字母异位词放到同一个List
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
