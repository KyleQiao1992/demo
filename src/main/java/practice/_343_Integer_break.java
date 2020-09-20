package practice;

import java.util.HashMap;
import java.util.Map;

public class _343_Integer_break {
    Map<Integer, Integer> memo = new HashMap<>();

    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        Integer res = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(i * (n - i), res);
            res = Math.max(i * integerBreak(n - i), res);
        }
        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        _343_Integer_break f = new _343_Integer_break();
        f.integerBreak(2);
    }
}
