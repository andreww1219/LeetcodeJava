package SuiXiangLu.DynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// 单词拆分
public class Solution139 {
    // 回溯 通过 32/47
    boolean result = false;
    void backtrace(String s, List<String> wordDict, StringBuilder sb) {
        if (sb.length() > s.length() || result) return;
        if (sb.toString().equals(s)) {
            result = true;
            return;
        }
        for (int i = 0; i < wordDict.size(); ++i) {
            String str = wordDict.get(i);
            sb.append(str);
            backtrace(s, wordDict, sb);
            sb.delete(sb.length() - str.length(), sb.length());
        }
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        backtrace(s, wordDict, new StringBuilder());
        return result;
    }
    // 动态规划
    @Test
    public void test() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak2(s, wordDict));
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        int bagSize = s.length();
        boolean[] dp = new boolean[bagSize + 1];
        dp[0] = true;
        for (int i = 1; i <= bagSize; ++i) {
            for (int j = 0; j < wordDict.size(); ++j) {
                String str = wordDict.get(j);
                int strLen = str.length();
                if (i >= strLen) {
                    dp[i] = dp[i] || (dp[i - strLen] && str.equals(s.substring(i - strLen, i)));
                }
            }
        }
        return dp[bagSize];
    }
}
