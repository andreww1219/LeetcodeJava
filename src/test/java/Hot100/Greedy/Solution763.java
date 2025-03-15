package Hot100.Greedy;


import java.util.ArrayList;
import java.util.List;

// 划分字母区间
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] record = new int[26]; // 记录每个字母最后的位置
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; ++i) record[arr[i] - 'a'] = i;
        // 类似跳跃游戏
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            end = Math.max(end, record[arr[i] - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
