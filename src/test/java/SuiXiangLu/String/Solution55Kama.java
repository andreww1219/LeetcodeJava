package SuiXiangLu.String;


import java.util.Scanner;

// 右旋字符串
public class Solution55Kama {
    // 初见
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        int cutpoint = input.length() - k;
        String output = input.substring(cutpoint) + input.substring(0, cutpoint);
        System.out.println(output);
    }
    private static String reverse(String str, int start, int end) {
        StringBuilder sb = new StringBuilder(str);
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        return sb.toString();
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        int len = input.length();

        input = reverse(input, 0, len - 1);
        input = reverse(input, 0, k - 1);
        input = reverse(input, k, len - 1);
        System.out.println(input);
    }

}
