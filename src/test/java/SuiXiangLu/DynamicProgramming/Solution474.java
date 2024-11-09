package SuiXiangLu.DynamicProgramming;


// 一和零
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 表示有 i 个 0 和 j 个 1 的最大子集数
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0; i < len; ++i) {
            char[] arr = strs[i].toCharArray();
            int zeroNum = 0, oneNum = 0;
            for (char ch: arr) {
                if (ch == '0') zeroNum++;
                else oneNum++;
            }
            for (int j = m; j >= zeroNum; --j) {
                for (int k = n; k >= oneNum; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNum][k - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
