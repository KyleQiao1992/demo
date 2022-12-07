package demo.leecode.dymamic_programming;

import java.util.Arrays;


public class _322_coin_change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        _322_coin_change f = new _322_coin_change();
        int[] coins = {1, 2, 5};
        int res = f.coinChange(coins, 11);
    }

}
