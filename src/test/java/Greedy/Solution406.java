package Greedy;


import java.awt.event.PaintEvent;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 根据身高重建队列
public class Solution406 {

    // 贪心 仿题解
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, (a, b)->{
            if (a[0] != b[0])
                return b[0] - a[0];
            return a[1] - b[1];
        });
        List<List<Integer>> que = new LinkedList<>();
        for (int i = 0; i < people.length; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(people[i][0]);
            list.add(people[i][1]);
            que.add(people[i][1], list);
        }

        int[][] res = new int[people.length][2];
        for (int i = 0; i < que.size(); ++i) {
            List<Integer> list = que.get(i);
            res[i][0] = list.get(0);
            res[i][1] = list.get(1);
        }
        return res;
    }
    // 贪心 标准题解
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (a, b)->{
            if (a[0] != b[0])
                return b[0] - a[0];
            return a[1] - b[1];
        });
        List<int[]> que = new LinkedList<>();
        for (int[] p: people) {
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }
}
