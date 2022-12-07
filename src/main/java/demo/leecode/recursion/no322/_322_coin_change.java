package demo.leecode.recursion.no322;

public class _322_coin_change {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        Integer res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }
        return res.equals(Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        _322_coin_change f = new _322_coin_change();
        int[] coins = {1, 2, 5};
        int res = f.coinChange(coins, 11);
    }

}
