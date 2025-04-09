package Misc.Backtrace;

import java.util.ArrayList;
import java.util.List;

// 冗余连接II
public class Solution685 {
    class UnionFindSet {
        int[] parent;
        UnionFindSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; ++i)
                parent[i] = i;
        }
        void join(int i, int j) {
            parent[root(j)] = root(i);
        }
        int root(int i) {
            if (parent[i] != i)
                parent[i] = root(parent[i]);
            return parent[i];
        }
        boolean same(int i, int j) {
            return root(i) == root(j);
        }
    }
    private boolean isTreeAfterRemoveEdge(int[][] edges, int dup) {
        int nodes = edges.length + 1;
        UnionFindSet set = new UnionFindSet(nodes);
        for (int i = 0; i < edges.length; ++i) {
            if (i == dup) continue;
            int[] edge = edges[i];
            if (set.same(edge[0], edge[1])) return false;
            set.join(edge[0], edge[1]);
        }
        return true;
    }
    private int[] findCircleFromRoot(int[][] edges) {
        int nodes = edges.length + 1;
        UnionFindSet set = new UnionFindSet(nodes);
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            if (set.same(edge[0], edge[1])) return edge;
            set.join(edge[0], edge[1]);
        }
        return new int[0];
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int edgeCnt = edges.length;
        // 找到入度为2的节点关联的边
        int[] inDegree = new int[edgeCnt + 1];
        for (int i = 0; i < edgeCnt; ++i) inDegree[edges[i][1]]++;
        List<Integer> dup = new ArrayList<>();
        for (int i = 0; i < edgeCnt; ++i)
            if (inDegree[edges[i][1]] == 2) dup.add(i);
        // 遍历所有边
        if (!dup.isEmpty()) {
            if (isTreeAfterRemoveEdge(edges, dup.get(1)))
                return edges[dup.get(1)];
            else
                return edges[dup.get(0)];
        } else {
            return findCircleFromRoot(edges);
        }
    }
}
