package Classic150.DoublePointer;


// 判断子序列
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS == 0) return true;
        for (int indexS = 0, indexT = 0; indexT < lenT; ++indexT) {
            if (s.charAt(indexS) == t.charAt(indexT))
                indexS++;
            if (indexS == lenS)
                return true;
        }
        return false;
    }
}
