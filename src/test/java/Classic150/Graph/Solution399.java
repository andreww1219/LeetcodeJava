package Classic150.Graph;


import java.util.*;

// 除法求值
public class Solution399 {
    private double NOT_CONNECTED = -1.0;

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {
        // 得到节点的数量
        int num = 0;
        Map<String, Integer> indexes = new HashMap<>();
        for (List<String> equation : equations) {
            String str1 = equation.get(0), str2 = equation.get(1);
            if (!indexes.containsKey(str1)) indexes.put(str1, num++);
            if (!indexes.containsKey(str2)) indexes.put(str2, num++);
        }
        // 初始化图
        double[][] graph = new double[num][num];
        for (int i = 0; i < num; ++i) {
            Arrays.fill(graph[i], NOT_CONNECTED);
            graph[i][i] = 1.0;
        }
        int len = equations.size();
        for (int i = 0; i < len; ++i) {
            List<String> equation = equations.get(i);
            int i1 = indexes.get(equation.get(0)), i2 = indexes.get(equation.get(1));
            double value = values[i];
            graph[i1][i2] = value;
            graph[i2][i1] = 1 / value;
        }
        // 查询
        int resLen = queries.size();
        double[] res = new double[resLen];
        for (int i = 0; i < resLen; ++i) {
            List<String> query = queries.get(i);
            String str1 = query.get(0), str2 = query.get(1);
            if (indexes.containsKey(str1) && indexes.containsKey(str2))
                res[i] = dfs(graph, new boolean[num],
                        indexes.get(str1),
                        indexes.get(str2));
            else
                res[i] = NOT_CONNECTED;
        }
        return res;
    }
    private double dfs(double[][] graph, boolean[] vis, int start, int end) {
        if (graph[start][end] != NOT_CONNECTED)
            return graph[start][end];
        vis[start] = true;
        int num = vis.length;
        for (int i = 0; i < num; ++i) {
            if (!vis[i] && graph[start][i] != NOT_CONNECTED) {
                double res = dfs(graph, vis, i, end);
                if (res != NOT_CONNECTED)
                    return graph[start][i] * res;
            }
        }
        return NOT_CONNECTED;
    }
}
