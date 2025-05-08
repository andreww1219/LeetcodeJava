package Classic150.Graph;


import java.util.Deque;
import java.util.LinkedList;

// 课程表II
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
            degree[prerequisite[1]]++;
        }
        // 拓扑排序
        int[] ans = new int[numCourses];
        int index = numCourses - 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i)
            if (degree[i] == 0)
                deque.addLast(i);
        int visCount = 0;
        while (!deque.isEmpty()) {
            int front = deque.pollFirst();
            ans[index--] = front;
            visCount++;
            for (int i = 0; i < numCourses; ++i) {
                if (graph[front][i]) {
                    degree[i]--;
                    if (degree[i] == 0)
                        deque.addLast(i);
                }
            }
        }
        return visCount == numCourses ? ans : new int[0];
    }
}
