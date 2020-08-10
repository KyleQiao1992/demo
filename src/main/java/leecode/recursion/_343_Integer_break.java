package leecode.recursion;

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
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, i * (n - i));
            res = Math.max(res, i * integerBreak(n - i));
        }
        memo.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        _343_Integer_break f = new _343_Integer_break();
        int res = f.integerBreak(10);
    }
}
