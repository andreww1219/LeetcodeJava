package Classic150.Backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 电话号码的字母组合
public class Solution17 {
    static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    List<String> ans;
    private void dfs(String digits, int cur, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String word = map.get(digits.charAt(cur));
        for (char ch: word.toCharArray()) {
            sb.append(ch);
            dfs(digits, cur + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() > 0)
            dfs(digits, 0, new StringBuilder());
        return ans;
    }
}
