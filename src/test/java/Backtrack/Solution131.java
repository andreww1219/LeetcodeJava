package Backtrack;

import java.util.ArrayList;
import java.util.List;

// 分割回文串
public class Solution131 {
    // 回溯题解
    List<List<String>> result1 = new ArrayList<>();
    List<String> path1 = new ArrayList<>();
    private void backtrace1(String s, int startIndex, StringBuilder sb) {
        if (startIndex == s.length()){
            result1.add(new ArrayList<>(path1));
            return;
        }
        for (int i = startIndex; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (check(sb)) {
                path1.add(sb.toString());
                backtrace1(s, i + 1, new StringBuilder());
                path1.remove(path1.size() - 1);
            }
        }
    }
    private boolean check(StringBuilder sb) {
        for (int i = 0, j = sb.length() - 1; i <= j; i++, j--)
            if (sb.charAt(i) != sb.charAt(j)) return false;
        return true;
    }
    public List<List<String>> partition1(String s) {
        backtrace1(s,  0, new StringBuilder());
        return result1;
    }

    // 回溯 + 动态规划

    List<List<String>> result2 = new ArrayList<>();
    List<String> path2 = new ArrayList<>();
    boolean[][] isPalindrome;
    private void backtrace2(String s, int startIndex) {
        if (startIndex == s.length()){
            result2.add(new ArrayList<>(path2));
            return;
        }
        for (int i = startIndex; i < s.length(); ++i) {
            if (isPalindrome[startIndex][i]) {
                path2.add(s.substring(startIndex, i + 1));
                backtrace2(s, i + 1);
                path2.remove(path2.size() - 1);
            }
        }
    }
    private void computePalindrome(String s) {
        int len = s.length();
        isPalindrome = new boolean[len][len];
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                if (j - i <= 1) isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                else isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }
    public List<List<String>> partition2(String s) {
        computePalindrome(s);
        backtrace2(s,  0);
        return result2;
    }
}
