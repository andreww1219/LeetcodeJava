package DynamicProgramming;


import org.junit.Test;

// 回文子串
public class Solution647 {
    @Test
    public void test() {
        String s = "aaaaa";
        System.out.println(countSubstrings1(s));
    }
    // 初见
    public int countSubstrings1(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        // dp[i][j] 表示 s[i: j]是回文子串
        boolean[][] dp = new boolean[len][len];
        // 初始化
        int res = len;
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
            if (i < len - 1) {
                dp[i][i + 1] = arr[i] == arr[i + 1];
                if (dp[i][i + 1]) res++;
            }
        }
        // 递推
        // 由于递推公式，需要从下向上，从左向右遍历
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 2; j < len; ++j) {
                dp[i][j] = dp[i + 1][j - 1]
                        ?  arr[i] == arr[j]
                        : false;
                if (dp[i][j]) res++;
            }
        }
        // 得到结果
        return res;
    }
    // 标准题解
    public int countSubstrings2(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        // dp[i][j] 表示 s[i: j]是回文子串
        boolean[][] dp = new boolean[len][len];
        // 初始化
        int res = 0;
        // 递推
        // 由于递推公式，需要从下向上，从左向右遍历
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; ++j) {
                dp[i][j] = arr[i] == arr[j] && (j - i <= 1 || dp[i + 1][j - 1]);
                if (dp[i][j]) res++;
            }
        }
        // 得到结果
        return res;
    }

}
