package MonotonicStack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// 下一个更大元素 I
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 单调栈得到 nums2 中每个数的下一个更大元素，保存在 map 中
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        // 取出
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
