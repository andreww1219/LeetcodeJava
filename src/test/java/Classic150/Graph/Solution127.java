package Classic150.Graph;


import java.util.*;

// 单词接龙
public class Solution127 {
    // 双向BFS优化
    private boolean isConvertable(String str1, String str2) {
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
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // 双向bfs
        int endIndex = wordList.indexOf(endWord);
        if (endIndex == -1) return 0;
        wordList.add(beginWord);
        int startIndex = wordList.size() - 1;
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        deque1.addLast(startIndex);
        deque2.addLast(endIndex);
        Set<Integer> vis1 = new HashSet<>();
        Set<Integer> vis2 = new HashSet<>();
        vis1.add(startIndex);
        vis2.add(endIndex);
        int cnt = 1;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            // 从遍历数量较少的一端前进
            if (deque1.size() > deque2.size()) {
                Deque<Integer> tmpDeque = deque1;
                deque1 = deque2;
                deque2 = tmpDeque;
                Set<Integer> tmpVis = vis1;
                vis1 = vis2;
                vis2 = tmpVis;
            }
            int size = deque1.size();
            while (size-- > 0) {
                int front = deque1.pollFirst();
                for (int i = 0; i < wordList.size(); ++i) {
                    if (vis1.contains(i) || !isConvertable(wordList.get(front), wordList.get(i)))
                        continue;
                    if (vis2.contains(i))
                        return cnt + 1;
                    vis1.add(i);
                    deque1.addLast(i);
                }
            }
            cnt++;
        }
        return 0;
    }

    // 初见，O(N^2 M)，超越5.72%
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
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 初始化图
        int nodeNum = wordList.size() + 1, len = wordList.size();
        boolean[][] graph = new boolean[nodeNum][nodeNum];
        for (int i = 0; i < len; ++i) {
            if (isNeighbor(beginWord, wordList.get(i))) {
                graph[0][i + 1] = true;
                graph[i + 1][0] = true;
            }
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (isNeighbor(wordList.get(i), wordList.get(j))) {
                    graph[i + 1][j + 1] = true;
                    graph[j + 1][i + 1] = true;
                }
            }
        }
        // bfs
        int endIndex = wordList.indexOf(endWord);
        if (endIndex == -1) return 0;
        boolean[] vis = new boolean[nodeNum];
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, 1});
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
        return 0;
    }
}
