package Hot100.SubString;


import java.util.ArrayDeque;
import java.util.Deque;

// 滑动窗口最大值
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < len; ++i) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.add(i);
            if (i >= k - 1)
                res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
