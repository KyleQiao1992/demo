package leecode.dymamic_programming.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public int knapsack01(int[] w, int[] v, int C) {

        if (w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if (C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if (n == 0 || C == 0)
            return 0;

        int[][] memo = new int[n][C + 1];

        for (int j = 0; j <= C; j++)
            memo[0][j] = (j >= w[0] ? v[0] : 0);

        for (int i = 1; i < n; i++)
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }

        return memo[n - 1][C];
    }

}
