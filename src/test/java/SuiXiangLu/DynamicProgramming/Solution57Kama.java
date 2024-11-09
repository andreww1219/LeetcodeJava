package SuiXiangLu.DynamicProgramming;

import java.util.Scanner;

// 爬楼梯（进阶版）
public class Solution57Kama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (i >= j) arr[i] += arr[i - j];
            }
        }
        System.out.println(arr[n]);
    }
}
