package leecode.recursion;

import java.util.HashMap;
import java.util.Map;

public class _343_Integer_break {
    Map<Integer, Integer> memo = new HashMap<>();

    public int integerBreak(int n) {
        return recursion(n);
    }

    //将n进行分割（至少分割两个部分），可以获得的最大乘积
    private Integer recursion(int n) {
        if (n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        Integer res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, i * (n - i));
            res = Math.max(res, i * recursion(n - i));
        }
        memo.put(n, res);
        return res;
    }
}
