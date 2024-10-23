package HashMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// 两个数组的交集
public class Solution349 {
    private final int SIZE = 1001;

    // 初见
    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] record=  new int[SIZE];
        for (int i = 0; i < SIZE; ++i)
            record[i] = 0;

        for (int num: nums1)
            record[num] = 1;

        int cnt = 0;
        for (int num: nums2){
            if (record[num] == 1){
                cnt++;
                record[num] = 2;
            }
        }

        int index = 0;
        int[] inter = new int[cnt];
        for (int i = 0; i < SIZE; ++i)
            if (record[i] == 2)
                inter[index++] = i;
        return inter;
    }
    // 未指定长度时使用 Set
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num: nums1)
            record.add(num);
        for (int num: nums2)
            if (record.contains(num))
                res.add(num);
        return res.stream().mapToInt(num -> num).toArray();
    }
    // 指定长度时，使用数组作记录，结果利用 HashSet 去重
    public int[] intersection3(int[] nums1, int[] nums2) {
        boolean[] record = new boolean[SIZE];
        Set<Integer> res = new HashSet<>();
        for (int num: nums1)
            record[num] = true;
        for (int num: nums2)
            if (record[num])
                res.add(num);
        return res.stream().mapToInt(num -> num).toArray();
    }
}
