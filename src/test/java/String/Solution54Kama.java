package String;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 替换数字
public class Solution54Kama {
    // 初见 O(n^2)
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < len; ++i){
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
                pos.add(i);
        }
        StringBuilder sb = new StringBuilder(str);
        int size = pos.size();
        String res = sb.substring(0, pos.get(0));
        for (int i = 0; i < size - 1; ++i){
            res += "number" + sb.substring(pos.get(i) + 1, pos.get(i + 1));
        }
        res += "number" + sb.substring(pos.get(size - 1), len);
        System.out.println(res);
    }

    // 数组填充类：扩容，从后往前
    private static final String REPLACE_WORD = "number";
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        int cnt = 0;
        for (int i = 0; i < len; ++i){
            if (Character.isDigit(str.charAt(i)))
                ++cnt;
        }
        char[] res = new char[len + (REPLACE_WORD.length() - 1) * cnt];
        int index = res.length - 1;
        for (int i = len - 1; i >= 0; --i) {
            if (Character.isDigit(str.charAt(i))){
                for (int j = REPLACE_WORD.length() - 1; j >= 0; --j)
                    res[index--] = REPLACE_WORD.charAt(j);
            } else {
                res[index--] = str.charAt(i);
            }
        }
        System.out.println(new String(res));
    }
}
