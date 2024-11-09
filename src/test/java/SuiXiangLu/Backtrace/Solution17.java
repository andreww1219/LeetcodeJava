package SuiXiangLu.Backtrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 电话号码的字母组合
public class Solution17 {
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));;
    }
    // 初见 使用map
    private static Map<Character, String> map = new HashMap<>();
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
//    private List<SuiXiangLu.String> result = new ArrayList<>();
//    private StringBuilder path = new StringBuilder();
//    private void backtrace(SuiXiangLu.String digits, int startIndex) {
//        if (path.length() == digits.length()){
//            result.add(path.toString());
//            return;
//        }
//        SuiXiangLu.String str = map.get(digits.charAt(startIndex));
//        for (int i = 0; i < str.length(); ++i) {
//            path.append(str.charAt(i));
//            backtrace(digits, startIndex + 1);
//            path.deleteCharAt(path.length() - 1);
//        }
//    }
//    public List<SuiXiangLu.String> letterCombinations(SuiXiangLu.String digits) {
//        if (!"".equals(digits))
//            backtrace(digits, 0);
//        return result;
//    }

    // 题解 使用 list
    private static List<String> list = new ArrayList<>();
    static {
        list.add("");
        list.add("");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");
    }
    private List<String> result = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    private void backtrace(String digits, int startIndex) {
        if (path.length() == digits.length()){
            result.add(path.toString());
            return;
        }
        String str = list.get(digits.charAt(startIndex) - '0');
        for (int i = 0; i < str.length(); ++i) {
            path.append(str.charAt(i));
            backtrace(digits, startIndex + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (!"".equals(digits))
            backtrace(digits, 0);
        return result;
    }
}
