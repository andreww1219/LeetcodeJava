package SuiXiangLu.DynamicProgramming;

// 判断子序列
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int cur = 0;
        for (int i = 0; cur < len1 && i < len2; ++i) {
            if (arr1[cur] == arr2[i]) cur++;
            if (cur == len1) break;
        }
        return cur == len1;
    }
}
