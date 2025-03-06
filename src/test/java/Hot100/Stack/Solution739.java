package Hot100.Stack;


import java.util.Deque;
import java.util.LinkedList;

// 每日温度
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Deque<Integer> deq = new LinkedList<>();
        int[] result = new int[len];
        // 维护一个单调递减的序列的下标
        for (int i = 0; i < len; i++) {
            int num = temperatures[i];
            while (!deq.isEmpty() && num > temperatures[deq.peek()]) {
                int index = deq.poll();
                result[index] = i - index;
            }
            deq.push(i);
        }
        return result;
    }
}
