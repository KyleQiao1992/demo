package leecode.recursion.no322;

import java.util.HashMap;
import java.util.Map;

public class _322_coin_change2 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        Integer res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int x = amount - coin;
            int sub = coinChange(coins, x);

            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);

        }
        res = res.equals(Integer.MAX_VALUE) ? -1 : res;
        memo.put(amount, res);
        return res;
    }

    public static void main(String[] args) {
        _322_coin_change f = new _322_coin_change();
        int[] coins = {1, 2, 5};
        int res = f.coinChange(coins, 11);
    }
}
