package Array;

import java.util.Scanner;

public class Solution58Kama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        // 前缀和
        int[] pre = new int[size + 1];
        pre[0] = 0;
        for (int i = 0; i < size; ++i){
            int num = scanner.nextInt();
            pre[i + 1] = pre[i] + num;
        }

        while (scanner.hasNextInt()){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            System.out.println(pre[right + 1] - pre[left]);
        }
    }
}
