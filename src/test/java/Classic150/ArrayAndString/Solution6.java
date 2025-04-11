package Classic150.ArrayAndString;


// Z字形变换
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < len; j += 2 * (numRows - 1)) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && j + 2 * (numRows - 1 - i) < len)
                    sb.append(s.charAt(j + 2 * (numRows - 1 - i)));
            }
        }
        return sb.toString();
    }
}
