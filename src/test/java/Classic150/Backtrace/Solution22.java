package Classic150.Backtrace;


import java.util.ArrayList;
import java.util.List;

// 括号生成
public class Solution22 {
    List<String> ans;
    private void dfs(int unused, int notMatch, StringBuilder sb) {
        if (unused == 0 && notMatch == 0) {
            ans.add(sb.toString());
            return;
        }
        // 使用左括号
        if (unused > 0) {
            sb.append('(');
            dfs(unused - 1, notMatch + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 使用右括号
        if (notMatch > 0) {
            sb.append(')');
            dfs(unused, notMatch - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
         ans = new ArrayList<>();
         dfs(n, 0, new StringBuilder());
         return ans;
    }
}
