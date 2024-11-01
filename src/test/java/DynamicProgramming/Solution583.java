package DynamicProgramming;

import org.junit.Test;

// 两个字符串的删除操作
public class Solution583 {
    @Test
    public void test() {
        String word1 = "leetcode", word2 = "tcod";
        System.out.println(minDistance(word1, word2));
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        // dp[i][j] 表示 word1[0: i-1] 和 word2[0: j-1] 的最小步数
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 1; i <= len1; ++i)
            dp[i][0] = i;
        for (int i = 1; i <= len2; ++i)
            dp[0][i] = i;
        // 递推
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                dp[i][j] = arr1[i - 1] == arr2[j - 1]
                            ? dp[i - 1][j - 1]
                            : Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[len1][len2];
    }
}
