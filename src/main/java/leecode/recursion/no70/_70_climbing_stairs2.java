package leecode.recursion.no70;

import java.util.HashMap;
import java.util.Map;

public class _70_climbing_stairs2 {
    public Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        return recursion(n);
    }

    private int recursion(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, recursion(n - 1) + recursion(n - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        _70_climbing_stairs2 f = new _70_climbing_stairs2();
        Integer res = f.climbStairs(45);
    }
}
