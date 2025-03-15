package Hot100.Heap;


import java.nio.file.Paths;
import java.util.PriorityQueue;

// 数据流的中位数
public class Solution295 {
    class MedianFinder {

        private PriorityQueue<Integer> pqSmaller;   // 小于中位数的pq, 大顶堆
        private PriorityQueue<Integer> pqGreater;   // 大于中位数的pq, 小顶堆
        public MedianFinder() {
            pqSmaller = new PriorityQueue<>((a, b) -> b - a);
            pqGreater = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            // 维护pqSmaller.size() == pq.Greater.size()或pqSmaller.size() == pqGreater.size() + 1
            if (pqSmaller.isEmpty() || num < pqSmaller.peek()) {
                pqSmaller.add(num);
                if (pqSmaller.size() > pqGreater.size() + 1)
                    pqGreater.add(pqSmaller.poll());
            } else {
                pqGreater.add(num);
                if (pqGreater.size() > pqSmaller.size())
                    pqSmaller.add(pqGreater.poll());
            }
        }

        public double findMedian() {
            if (pqSmaller.size() == pqGreater.size())
                return (pqSmaller.peek() + pqGreater.peek()) * 0.5;
            return pqSmaller.peek();
        }
    }
}
