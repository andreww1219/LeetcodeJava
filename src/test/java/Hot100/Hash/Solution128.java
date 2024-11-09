package Hot100.Hash;


import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 最长连续序列
public class Solution128 {
    @Test
    public void test() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive1(nums));
    }
    // 初见
    public int longestConsecutive1(int[] nums) {
        // (key, value)表示key所在的最长数字连续序列的长度
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            if (map.containsKey(num)) continue; // 去重
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int val = left + right + 1;
            res = Math.max(res, val);
            map.put(num, val);
            if (left != 0)
                map.replace(num - left, val);
            if (right != 0)
                map.replace(num + right, val);
        }
        return res;
    }
    // 使用 HashSet
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int res = 0;
        for (int num: set) {
           if (!set.contains(num - 1)) {
               int len = 1, cur = num;
               while (set.contains(cur + 1)) {
                   cur++;
                   len++;
               }
               res = Math.max(res, len);
           }
        }
        return res;
    }
}
