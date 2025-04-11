package Classic150.ArrayAndString;


// 最长公共前缀
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0, len = strs.length;
        while (true) {
            if (index >= strs[0].length()) return sb.toString();
            char ch = strs[0].charAt(index);
            for (String str: strs) {
                if (index >= str.length() || str.charAt(index) != ch)
                    return sb.toString();
            }
            sb.append(ch);
            index++;
        }
    }
}
