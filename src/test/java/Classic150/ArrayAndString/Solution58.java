package Classic150.ArrayAndString;

// 最后一个单词的长度
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int ans = 0;
        int last = len - 1;
        while (s.charAt(last) == ' ') last--;
        while (last >= 0 && s.charAt(last) != ' ') {
            last--;
            ans++;
        }
        return ans;
    }
}
