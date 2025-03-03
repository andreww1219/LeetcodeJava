package Hot100.Backtrace;

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
    List<String> result = new ArrayList<>();
    private void backtrace(char[] digits, StringBuilder sb) {
        int size = sb.length();
        if (size == digits.length) {
            result.add(new String(sb));
            return;
        }
        char[] chars = map.get(digits[size]).toCharArray();
        for (char ch : chars) {
            sb.append(ch);
            backtrace(digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        char[] digitsArr = digits.toCharArray();
        if(digitsArr.length > 0 ) backtrace(digitsArr, new StringBuilder());
        return result;
    }
}
