package Classic150.ArrayAndString;


// 加油站
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int cur = 0, start = 0;
        int len = gas.length;
        for (int i = 0; i < len; ++i) {
            cur += gas[i];
            if (cur < cost[i]) {
                cur = 0;
                start = (i + 1) % len;
            }
            totalGas += gas[i];
            totalCost += cost[i];
        }
        return totalGas >= totalCost ? start : -1;
    }
}
