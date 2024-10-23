package Greedy;


import java.awt.event.ActionListener;
import java.util.Arrays;

// 单调递增的数字
public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        String num_str = String.valueOf(n);
        char[] num = num_str.toCharArray();
        int len = num.length;
        int flag = len;    // 字符 9 开始的位置
        for (int i = len - 1; i > 0; --i) {
            if (num[i] < num[i - 1]) {
                flag = i;
                num[i - 1]--;
            }
        }
        for (int i = flag; i < len; ++i)
            num[i] = '9';
        return Integer.parseInt(String.valueOf(num));
    }
}
