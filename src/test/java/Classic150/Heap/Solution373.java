package Classic150.Heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 查找和最小的K对数字
public class Solution373 {
    // 初见，最大堆解法，超过10%
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                b[0] + b[1] - a[0] - a[1]);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < len2; ++j) {
                if (pq.size() < k) {
                    pq.add(new int[]{nums1[i], nums2[j]});
                } else {
                    int[] peek = pq.peek();
                    if (peek[0] + peek[1] > nums1[i] + nums2[j]) {
                        pq.poll();
                        pq.add(new int[]{nums1[i], nums2[j]});
                    } else
                        break;
                }
            }
        }
        for (int[] item: pq) {
            List<Integer> pair = new ArrayList<>();
            pair.add(item[0]);
            pair.add(item[1]);
            ans.add(pair);
        }
        return ans;
    }
    // 题解，小顶堆，超过97%
    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] - b[0]);
        pq.add(new int[]{nums1[0] + nums2[0], 0, 0});
        List<List<Integer>> ans = new ArrayList<>();
        while (ans.size() < k) {
            int[] peek = pq.poll();
            int i = peek[1], j = peek[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (j == 0 && i + 1 < len1)
                pq.add(new int[]{nums1[i + 1] + nums2[0], i + 1, 0});
            if (j + 1 < len2)
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
        }
        return ans;
    }
}
