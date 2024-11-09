package Hot100.Hash;


import java.util.*;

// 字母异位词分组
public class Solution49 {
    String sortStr(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String key = sortStr(str);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value: map.values())
            res.add(value);
        return res;
    }
}
