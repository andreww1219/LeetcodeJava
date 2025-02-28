package Hot100.GraphTheory;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

// 课程表
public class Solution207 {
    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}};
        System.out.println(canFinish2(numCourses, prerequisites));
    }
    // 初见 Floyd判环 O(n^3) 超时
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        final int IMPOSSIBLE_VAL = numCourses + 1;
        for (int i = 0; i < numCourses; ++i)
            for (int j = 0; j < numCourses; ++j)
                graph[i][j] = IMPOSSIBLE_VAL;
        for (int[] prerequisite: prerequisites)
            graph[prerequisite[1]][prerequisite[0]] = 1;
        for (int k = 0; k < numCourses; ++k)
            for (int i = 0; i < numCourses; ++i)
                for (int j = 0; j < numCourses; ++j)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        for (int i = 0; i < numCourses; ++i)
            if (graph[i][i] != IMPOSSIBLE_VAL) return false;
        return true;
    }
    // 拓扑排序
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; ++i)
            for (int j = 0; j < numCourses; ++j)
                graph[i][j] = false;
        int[] degree = new int[numCourses]; // 入度
        for (int[] prerequisite: prerequisites) {
            graph[prerequisite[1]][prerequisite[0]] = true;
            degree[prerequisite[0]]++;
        }
        // 拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i)
            if (degree[i] == 0) queue.add(i);
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int course = queue.poll();
            for (int i = 0; i < numCourses; ++i) {
                if (!graph[course][i]) continue;
                degree[i]--;
                if (degree[i] == 0)
                    queue.add(i);
            }
        }
        return cnt == numCourses;
    }
}
