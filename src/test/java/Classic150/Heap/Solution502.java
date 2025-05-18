package Classic150.Heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// IPO
public class Solution502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; ++i) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int selected = 0, res = w, iter = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while (selected < k) {
            while (iter < len && arr[iter][1] <= res) {
                maxHeap.add(arr[iter][0]);
                iter++;
            }
            if (maxHeap.isEmpty())
                break;
            res += maxHeap.remove();
            selected++;
        }
        return res;
    }
}
