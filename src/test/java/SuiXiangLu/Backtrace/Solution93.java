package SuiXiangLu.Backtrace;

import java.util.ArrayList;
import java.util.List;

// 复原IP地址
public class Solution93 {
    private List<String> result = new ArrayList<>();
    private void backtrace(String s, int startIndex, List<String> path) {
        if (path.size() == 4) {
            if (startIndex != s.length())
                return;
            StringBuilder sb = new StringBuilder(path.get(0));
            for (int i = 1; i < path.size(); ++i)
                sb.append("." + path.get(i));
            result.add(sb.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (isValid(sb.toString())) {
                path.add(sb.toString());
                backtrace(s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isValid(String str) {
        if (str.startsWith("0"))
            return str.length() == 1;
        if (str.length() > 3)
            return false;
        int val = Integer.parseInt(str);
        return val <= 255 && val >= 0;
    }
    public List<String> restoreIpAddresses(String s) {
        backtrace(s, 0, new ArrayList<>());
        return result;
    }
}
