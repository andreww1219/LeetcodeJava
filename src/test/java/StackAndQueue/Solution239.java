package StackAndQueue;

import java.util.*;

// 滑动窗口最大值
public class Solution239 {
    // 暴力  O(n * k) 报 TLE
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; ++i){
            int max = nums[i];
            for (int j = i + 1; j < i + k; ++j)
                max = Math.max(max, nums[j]);
            res[i] = max;
        }
        return res;
    }
    // 队列 + 建立最大堆 O(n * log k)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k - 1; ++i)
            queue.addLast(nums[i]);

        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; ++i){
            queue.addLast(nums[i]);
            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    Comparator.reverseOrder()
            );
            queue.forEach((item)->pq.add(item));
            res[i - k + 1] = pq.peek();
            queue.removeFirst();
        }
        return res;
    }

    // 队列，维护【升序下标对应降序元素】的队列
    public int[] maxSlidingWindow3(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; ++i){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; ++i){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()])
                queue.removeLast();
            queue.addLast(i);
            while (queue.peekFirst() <= i - k)
                queue.removeFirst();
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}
