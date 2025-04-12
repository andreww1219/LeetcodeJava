package Classic150.DoublePointer;


import org.junit.Test;

// 验证回文串
public class Solution125 {
    @Test
    public void test() {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
    private boolean isAlphabet(char ch) {
        return (ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z');
    }
    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private char toLowerCase(char ch) {
        return (char) ((ch >= 'a' && ch <= 'z') ? ch : ch - 'A' + 'a');
    }
    public boolean isPalindrome(String s) {
        int len = s.length();
        int l = 0, r = len - 1;
        while (l < r) {
            while (l < r && !isAlphabet(s.charAt(l)) && !isNumber(s.charAt(l)))
                l++;
            while (l < r && !isAlphabet(s.charAt(r)) && !isNumber(s.charAt(r)))
                r--;
            if (l >= r) break;
            char chL = s.charAt(l), chR = s.charAt(r);
            if (isAlphabet(chL) && isAlphabet(chR)) {
                if (toLowerCase(chL) != toLowerCase(chR)) return false;
            } else if (isNumber(chL) && isNumber(chR)) {
                if (chL != chR) return false;
            } else return false;
            l++;
            r--;
        }
        return true;
    }
}
