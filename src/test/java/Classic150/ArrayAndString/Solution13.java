package Classic150.ArrayAndString;

import java.util.HashMap;
// 罗马数字转整数
public class Solution13 {
    static HashMap<Character, Integer> charToNumMap;
    static {
        charToNumMap = new HashMap();
        charToNumMap.put('I', 1);
        charToNumMap.put('V', 5);
        charToNumMap.put('X', 10);
        charToNumMap.put('L', 50);
        charToNumMap.put('C', 100);
        charToNumMap.put('D', 500);
        charToNumMap.put('M', 1000);
    }
    public int romanToInt(String s) {
        int curUnit = 1000;
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            int unit = charToNumMap.get(ch);
            sum += unit;
            if (unit < curUnit) {
                curUnit = unit;
            } else if (unit > curUnit) {
                sum -= 2 * charToNumMap.get(s.charAt(i - 1));
            }
        }
        return sum;
    }
}
