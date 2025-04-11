package Classic150.ArrayAndString;

// H指数
public class Solution274 {
    public int hIndex(int[] citations) {
        int len = citations.length; // 最多不过len
        int[] counter = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            if (citations[i] >= len) counter[len]++;
            else counter[citations[i]]++;
        }
        int sum = 0;
        for (int i = len; i >= 0; --i) {
            sum += counter[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}
