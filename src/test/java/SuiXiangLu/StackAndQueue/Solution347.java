package SuiXiangLu.StackAndQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 前 K 个高频元素
public class Solution347 {
    Comparator<Map.Entry<Integer, Integer>> cmp = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    };
    // 基于大顶堆
    public int[] topKFrequent1(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(cmp);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            if (map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i)
            res[i] = pq.poll().getKey();
        return res;
    }
    // 基于小顶堆 能够达到 O（N * log k)
    public int[] topKFrequent2(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(cmp);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (pq.size() == k){
                if (pq.peek().getValue() < entry.getValue()){
                    pq.poll();
                    pq.add(entry);
                }
            } else {
                pq.add(entry);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i)
            res[i] = pq.poll().getKey();
        return res;
    }
}
