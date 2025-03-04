package Hot100.Backtrace;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 分割回文串
public class Solution131 {
    @Test
    public void test() {
        String s = "aab";
        System.out.println(partition2(s));
    }
    // 初见，回溯无记忆化搜索
    List<List<String>> result = new ArrayList<>();
    private boolean check(StringBuilder sb) {
        // 判断回文串
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    private void backtrace(String str, List<String> strings, StringBuilder curStr, int index) {
        if (index == str.length() && curStr.length() == 0) {
            result.add(new ArrayList<>(strings));
            return;
        }
        int len = str.length();
        for (int i = index; i < len; ++i) {
            curStr.append(str.charAt(i));
            if (check(curStr)) {
                strings.add(curStr.toString());
                backtrace(str, strings, new StringBuilder(), i + 1);
                strings.remove(strings.size() - 1);
            }
        }
    }
    public List<List<String>> partition1(String s) {
        backtrace(s, new ArrayList<>(), new StringBuilder(), 0);
        return result;
    }
    // 官方题解，动态规划预处理
    List<List<String>> ans = new ArrayList<>();
    List<String> res = new ArrayList<>();
    private void dfs(StringBuilder str, boolean[][] dp, int index) {
        int len = str.length();
        if (index == len) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < len; ++i) {
            if (dp[index][i]) {
                res.add(str.substring(index, i + 1));
                dfs(str,dp, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }

    public List<List<String>> partition2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i)
            Arrays.fill(dp[i], true);
        for (int i = len - 1; i >= 0; i--)
            for (int j = i + 1; j < len; ++j)
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        dfs(new StringBuilder(s), dp, 0);
        return ans;
    }
}
