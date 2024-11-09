package SuiXiangLu.DynamicProgramming;


import org.junit.Test;

// 不同的子序列
public class Solution115 {
    @Test
    public void test() {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }
    public int numDistinct(String s, String t) {
        int len1 = t.length(), len2 = s.length();
        char[] arr1 = t.toCharArray();
        char[] arr2 = s.toCharArray();
        // dp[i][j] 表示从 s[0: j-1] 中得到 t[0: i-1] 的方案数
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化 dp[0][i] = 1  dp[i][0] = 0
        for (int i = 1; i <= len1; ++i)
            dp[i][0] = 0;
        for (int i = 0; i <= len2; ++i)
            dp[0][i] = 1;
        // 递推
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                dp[i][j] = arr1[i - 1] == arr2[j - 1]
                        ? dp[i - 1][j - 1] + dp[i][j - 1]
                        : dp[i][j - 1];
            }
        }
        return dp[len1][len2];
    }
}
