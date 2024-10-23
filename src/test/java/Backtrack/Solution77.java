package Backtrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 组合
public class Solution77 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtrace(int n, int k, int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        // 还需要 k - path.size() 个元素
        for (int i = startIndex; i <= n - (k - path.size()) + 1; ++i) {
            path.add(i);
            backtrace(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        backtrace(n, k, 1);
        return result;
    }
}
