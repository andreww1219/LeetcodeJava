package SuiXiangLu.Greedy;


import java.util.ArrayList;
import java.util.List;

// 划分字母区间
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); ++i ) {
            record[s.charAt(i) - 'a'] = i;
        }
        int end = 0, start = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            end = Math.max(end, record[s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
