package Classic150.Graph;


import java.util.Deque;
import java.util.LinkedList;

// 最小基因变化
public class Solution433 {
    private boolean isNeighbor(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int dif = 0, len = str1.length();
        for (int i = 0; i < len; ++i) {
            if (str1.charAt(i) != str2.charAt(i))
                dif++;
            if (dif > 1)
                return false;
        }
        return true;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 初始化图
        int nodeNum = bank.length + 1, len = bank.length;
        boolean[][] graph = new boolean[nodeNum][nodeNum];
        for (int i = 0; i < len; ++i) {
            if (isNeighbor(startGene, bank[i])) {
                graph[0][i + 1] = true;
                graph[i + 1][0] = true;
            }
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (isNeighbor(bank[i], bank[j])) {
                    graph[i + 1][j + 1] = true;
                    graph[j + 1][i + 1] = true;
                }
            }
        }
        // bfs
        int endIndex = -1;
        for (int i = 0; i < len; ++i) {
            if (bank[i].equals(endGene)) {
                endIndex = i + 1;
                break;
            }
        }
        if (endIndex == -1) return -1;
        boolean[] vis = new boolean[nodeNum];
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, 0});
        vis[0] = true;
        while (!deque.isEmpty()) {
            int[] front = deque.pollFirst();
            int node = front[0], step = front[1];
            for (int i = 0; i < nodeNum; ++i) {
                if (!vis[i] && graph[node][i]) {
                    if (i == endIndex) return step + 1;
                    vis[i] = true;
                    deque.addLast(new int[]{i, step + 1});
                }
            }
        }
        return -1;
    }
}
