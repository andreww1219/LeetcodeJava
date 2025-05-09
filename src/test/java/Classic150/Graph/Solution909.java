package Classic150.Graph;


import java.util.*;

// 蛇梯棋
public class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Deque<int[]> deque = new LinkedList<>();
        vis[1] = true;
        deque.addLast(new int[]{1, 0}); // 编号，步数
        while (!deque.isEmpty()) {
            int[] front = deque.pollFirst();
            int id = front[0], step = front[1];
            for (int i = 1; i <= 6 && id + i < n * n; ++i) {
                int next = id + i;
                int[] index = id2idx(next, n);
                if (board[index[0]][index[1]] != -1)
                    next = board[index[0]][index[1]];
                if (next == n * n) return step + 1;
                if (!vis[next]) {
                    vis[next] = true;
                    deque.addLast(new int[]{next, step + 1});
                }
            }
        }
        return -1;
    }
    private int[] id2idx(int id, int n) {
        int[] index = new int[2];
        int row = (id - 1) / n, col = (id - 1) % n;
        index[0] = n - 1 - row;
        index[1] = row % 2 == 0 ? col : n - 1 - col;
        return index;
    }

//    public int snakesAndLadders(int[][] board) {
//        // 得到编号与坐标的对应
//        List<int[]> indexes = new ArrayList<>();
//        int n = board.length;
//        if (n == 1) return 0;
//        boolean order = true;
//        for (int i = n - 1; i >= 0; --i) {
//            for (int j = 0; j < n; ++j) {
//                int[] index = new int[2];
//                index[0] = i;
//                index[1] = order ? j : n - 1 - j;
//                indexes.add(index);
//            }
//            order = !order;
//        }
//        // 得到一张图
//        int nodeNum = n * n;
//        boolean[][] graph = new boolean[nodeNum][nodeNum];
//        for (int i = 0; i < nodeNum; ++i) {
//            int[] index = indexes.get(i);
//            if (board[index[0]][index[1]] != -1)
//                graph[i][board[index[0]][index[1]] - 1] = true;
//            for (int j = 1; j <= 6 && i + j < nodeNum; ++j)
//                graph[i][i + j] = true;
//        }
//        // bfs
//        boolean[] vis = new boolean[nodeNum];
//        Deque<Integer> nodes = new LinkedList<>();
//        nodes.addLast(0);
//        vis[0] = true;
//        int steps = 1;
//        while (true) {
//            int size = nodes.size();
//            for (int i = 0; i < size; ++i) {
//                int front = nodes.pollFirst();
//                for (int j = 0; j < nodeNum; ++j) {
//                    if (!vis[j] && graph[front][j]) {
//                        if (j == nodeNum - 1) return steps;
//                        nodes.addLast(j);
//                        vis[j] = true;
//                    }
//                }
//            }
//            steps++;
//        }
//    }
}
