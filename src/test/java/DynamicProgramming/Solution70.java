package DynamicProgramming;


import java.util.Arrays;

// 爬楼梯
public class Solution70 {
    private final static int MAX_LENGTH = 64;
    static int[] climbs = new int[MAX_LENGTH];
    static {
        Arrays.fill(climbs, -1);
        climbs[0] = 1;
    }
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (climbs[n] != -1) return climbs[n];
        climbs[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return climbs[n];
    }
}
