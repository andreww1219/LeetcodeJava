package Hot100.DynamicProgramming;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 单词拆分
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
