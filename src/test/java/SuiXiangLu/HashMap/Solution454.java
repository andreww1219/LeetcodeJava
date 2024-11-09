package SuiXiangLu.HashMap;


import java.util.*;

// 四数相加 II
public class Solution454 {
    Map<Integer, Integer> getSumMap(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                int sum = nums1[i] + nums2[j];
                if (map.containsKey(sum))
                    map.replace(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }
        return map;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = getSumMap(nums1, nums2);
        Map<Integer, Integer> map2 = getSumMap(nums3, nums4);
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry: map1.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(0 - key))
                cnt += value * map2.get(0 - key);
        }
        return cnt;
    }
}
