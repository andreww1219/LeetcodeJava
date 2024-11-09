package SuiXiangLu.String;

import org.junit.Test;

// 反转字符串 II
public class Solution541 {
    @Test
    public void test(){
        String str = "abcdefg";
        int k = 2;
        System.out.println(reverseStr1(str, k));
    }
    private int min (int a, int b){
        return a < b? a: b;
    }
    // 初见
    public String reverseStr1(String s, int k) {
        int len = s.length();
        int l = 0, r = min(k - 1, len - 1);
        StringBuilder sb = new StringBuilder(s);
        while (l < len){
            int tempL = l, tempR = r;
            while (tempL < tempR){
                char temp = sb.charAt(tempL);
                sb.setCharAt(tempL, sb.charAt(tempR));
                sb.setCharAt(tempR, temp);
                tempL++;
                tempR--;
            }
            l += 2 * k;
            r = min(l + k - 1, len - 1);
        }
        return sb.toString();
    }
    // more elegant
    public String reverseStr2(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < len; i += 2 * k){
            int start = i;
            int end = min(len - 1, start + k - 1);
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
        }
        return sb.toString();
    }
}
