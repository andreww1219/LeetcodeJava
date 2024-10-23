package DynamicProgramming;

import java.util.Arrays;

// 斐波那契数
public class Solution509 {
    private final static int MAX_LENGTH = 32;
    static int[] fibs = new int[MAX_LENGTH];
    static {
        Arrays.fill(fibs, -1);
        fibs[0] = 0;
        fibs[1] = 1;
    }
    public int fib(int n) {
        if (fibs[n] != -1)
            return fibs[n];
        fibs[n] = fib(n - 1) + fib(n - 2);
        return fibs[n];
    }
}
