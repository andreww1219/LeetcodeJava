package Hot100.Heap;


import java.util.*;
import java.util.stream.Collectors;

// 前K个高频元素
public class Solution347 {
//    private void findTopKFrequent(List<Map.Entry<Integer, Integer>> arr, int k) {
//        List<Map.Entry<Integer, Integer>> equal = new ArrayList<>();
//        List<Map.Entry<Integer, Integer>> smaller = new ArrayList<>();
//        List<Map.Entry<Integer, Integer>> greater = new ArrayList<>();
//        int pivot = arr.get(new Random().nextInt(arr.size())).getValue();
//        for (Map.Entry<Integer, Integer> entry: arr) {
//            if (entry.getValue() > pivot) greater.add(entry);
//            else if (entry.getValue() < pivot) smaller.add(entry);
//            else equal.add(entry);
//        }
//        if (greater.size() > k) {
//            findTopKFrequent(greater, k);
//            return;
//        }
//        result.addAll(greater.stream()
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList()));
//        if (greater.size() + equal.size() > k) {
//            findTopKFrequent(equal, k - greater.size());
//            return;
//        }
//        result.addAll(equal.stream()
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList()));
//        if (result.size() < k) findTopKFrequent(smaller, k - (greater.size() + equal.size()));
//    }


    // 哈希表+桶排爆内存 时间O(N) 空间O(NK)
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int[][] bucket = new int[nums.length + 1][map.size()];
        int[] bucketSize = new int[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            bucket[cnt][bucketSize[cnt]++] = num;
        }
        int[] ans = new int[k];
        int offset = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int j = 0; j < bucketSize[i]; j++) {
                ans[offset++] = bucket[i][j];
                if (offset == k) break;
            }
            if (offset == k) break;
        }
        return ans;
    }

    // 哈希表+堆    时间(NlogK) 空间O(N)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry);
                continue;
            }
            if (pq.peek().getValue() < entry.getValue()) {
                pq.poll();
                pq.add(entry);
            }
        }
        return pq.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
