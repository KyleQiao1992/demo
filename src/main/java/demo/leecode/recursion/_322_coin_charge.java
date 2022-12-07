package demo.leecode.recursion;

import java.util.*;

/**
 * 超时
 */
public class _322_coin_charge {
    List<List<Integer>> res = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, new LinkedList<>());
        Integer minLength = Integer.MAX_VALUE;
        for (List list : res) {
            minLength = Math.min(list.size(), minLength);
        }
        return minLength.equals(Integer.MAX_VALUE) ? -1 : minLength;
    }

    private void dfs(int[] coins, int amount, LinkedList<Integer> p) {
        Integer sum = 0;
        for (int t : p) {
            sum += t;
        }
        if (sum > amount) {
            return;
        }
        if (sum == amount) {
            res.add(new LinkedList<>(p));
        }
        for (int i = 0; i < coins.length; i++) {
            p.add(coins[i]);
            dfs(coins, amount, p);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] coins = {2};
        _322_coin_charge f = new _322_coin_charge();
        Integer res = f.coinChange(coins, 3);
    }
}
