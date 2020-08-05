package leecode.recursion;

public class _322_coin_charge2 {
    public int coinChange(int[] coins, int amount) {
        Integer n = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            n = Math.min(n, coinChange(coins, amount - coin) + 1);
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        _322_coin_charge2 f = new _322_coin_charge2();
        Integer res = f.coinChange(a, 11);
    }
}
