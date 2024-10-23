package Greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 加油站
public class Solution134 {
    @Test
    public void test() {
        int[] gas = {5, 8, 2, 8};
        int[] cost = {6, 5, 6, 6};
        System.out.println(canCompleteCircuit1(gas, cost));
    }
    // 初见 暴力 O（n^2)
    class GasAndCost {
        public int index;
        public int gas;
        public int cost;
        public GasAndCost (int index, int gas, int cost) {
            this.index = index; this.gas = gas; this.cost = cost;};
    }
    private Comparator<GasAndCost> cmp = new Comparator<GasAndCost>() {
        @Override
        public int compare(GasAndCost o1, GasAndCost o2) {
            return (o2.gas - o2.cost) - (o1.gas - o1.cost);
        }
    };
    public int canCompleteCircuit1 (int[] gas, int[] cost) {
        List<GasAndCost> list = new ArrayList<>();
        for (int i = 0; i < gas.length; ++i)
            list.add(new GasAndCost(i, gas[i], cost[i]));
        list.sort(cmp);
        for (int i = 0; i < list.size(); ++i)
            if (list.get(i).gas - list.get(i).cost < 0)
                return -1;
            else if (isValid(gas, cost, list.get(i).index))
                return list.get(i).index;
        return -1;
    }
    private boolean isValid (int[] gas, int[] cost, int index) {
        int curGas = 0;
        for (int i = 0; i < gas.length; ++i) {
            int curIndex = (index + i) % gas.length;
            curGas += gas[curIndex];
            if (curGas < cost[curIndex]) return false;
            curGas -= cost[curIndex];
        }
        return true;
    }
    // 标准题解1 贪心
    public int canCompleteCircuit2 (int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < gas.length; ++i) {
            rest[i] = gas[i] - cost[i];
            sum += rest[i];
            min = Math.min(min, sum);
        }
        if (sum < 0) return -1;
        if (min >= 0) return 0;
        for (int i = gas.length - 1; i >= 0; --i) {
            min += rest[i];
            if (min >= 0) return i;
        }
        return -1;
    }
    // 标准题解2 贪心
    public int canCompleteCircuit3 (int[] gas, int[] cost) {
        int start = 0, totalSum = 0, curSum = 0;
        for (int i = 0; i < gas.length; ++i) {
            int rest = gas[i] - cost[i];
            totalSum += rest;
            curSum += rest;
            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }
        if (totalSum < 0) return -1;
        return start;
    }
}
