package Misc.UnionFindSet;


// 冗余连接
public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len + 1];
        for (int i = 1; i <= len; ++i) parent[i] = i;
        int[] res = new int[0];
        for (int i = 0; i < len; ++i) {
            int[] edge = edges[i];
            int from = edge[0], to = edge[1];
            if (find(parent, from) != find(parent, to))
                union(parent, from, to);
            else
                res = edge;
        }
        return res;
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }
    private void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = parent[find(parent, j)];
    }
}
