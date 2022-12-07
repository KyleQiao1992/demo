package demo.leecode.dymamic_programming;

import java.util.HashMap;
import java.util.Map;

public class _70_climbing_stairs {

    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        memo.put(1, 1);

        for (int i = 2; i <= n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }
}
