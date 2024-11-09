package SuiXiangLu.MonotonicStack;


import java.util.*;

// 下一个更大元素 I
public class Solution496 {
    // 写法一
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
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
    // 写法二：用 nums1 中的数字和下标做映射
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // 单调栈得到 nums2 中每个数的下一个更大元素，保存在 map 中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
             map.put(nums1[i], i);
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums2[0]);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int top = stack.pop();
                if (map.containsKey(top))
                    res[map.get(top)] = nums2[i];
            }
            stack.push(nums2[i]);
        }
        return res;
    }
}
