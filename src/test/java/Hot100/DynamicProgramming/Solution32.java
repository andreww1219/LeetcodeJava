package Hot100.DynamicProgramming;


import org.junit.Test;

// 最长有效括号
public class Solution32 {
    @Test
    public void test() {
        System.out.println(longestValidParentheses("(())()(()(("));
    }
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0;
        int result = 0;
        for (int i = 1; i < len; ++i) {
            if (s.charAt(i) == '(') continue;
            if (s.charAt(i - 1) == '(')
                dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = i - dp[i - 1] - 2 >= 0 ?
                        dp[i - dp[i - 1] - 2] + dp[i - 1] + 2 :
                        dp[i - 1] + 2;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
