package Classic150.Heap;


import java.util.Comparator;
import java.util.PriorityQueue;

// 数据流中的中位数
public class Solution295 {
    class MedianFinder {
        PriorityQueue<Integer> smaller;
        PriorityQueue<Integer> greater;
        public MedianFinder() {
            smaller = new PriorityQueue<>(Comparator.reverseOrder());
            greater = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (smaller.isEmpty()) {
                smaller.add(num);
                return;
            }
            if (num > smaller.peek())
                greater.add(num);
            else
                smaller.add(num);
            if (greater.size() > smaller.size())
                smaller.add(greater.poll());
            else if (greater.size() + 1 < smaller.size())
                greater.add(smaller.poll());
        }

        public double findMedian() {
            if (smaller.size() == greater.size())
                return (smaller.peek() + greater.peek()) * 1.0 / 2;
            return smaller.peek();
        }
    }
}
