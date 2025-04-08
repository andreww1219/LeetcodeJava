package Misc.UnionFindSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

// 省份数量
public class Solution547 {
    // 并查集解法 O(n^2logn)
    class UnionFindSet {
        int[] parent;
        int size;
        UnionFindSet(int n) {
            size = n;
            parent = new int[size];
            Arrays.fill(parent, -1);
        }
        public int root(int i) {
            if (parent[i] == -1)
                return i;
            parent[i] = root(parent[i]);
            return parent[i];
        }
        public void join(int i, int j) {
            int rootI = root(i), rootJ = root(j);
            if (rootI != rootJ)
                parent[rootJ] = rootI;
        }
        public int numOfSets() {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < size; ++i)
                set.add(root(i));
            return set.size();
        }
    }
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        UnionFindSet unionFindSet = new UnionFindSet(n);
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (isConnected[i][j] == 1)
                    unionFindSet.join(i, j);
        return unionFindSet.numOfSets();
    }
    // 深搜
    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (vis[i]) continue;
            vis[i] = true;
            cnt++;
            LinkedList<Integer> stack = new LinkedList<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int top = stack.pop();
                for (int j = 0; j < n; ++j) {
                    if (!vis[j] && isConnected[j][top] == 1) {
                        vis[j] = true;
                        stack.push(j);
                    }
                }
            }
        }
        return cnt;
    }
}
