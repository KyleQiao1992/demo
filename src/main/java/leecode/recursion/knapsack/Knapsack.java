package leecode.recursion.knapsack;

import java.util.List;

public class Knapsack {

    public Integer knapsack(List<Integer> w, List<Integer> v, Integer C) {
        return dp(w, v, w.size() - 1, C);
    }

    private Integer dp(List<Integer> w, List<Integer> v, Integer c, Integer index) {
        if (index <= 0 || c <= 0) {
            return 0;
        }
        Integer res = dp(w, v, c, index - 1);

        if (c >= w.get(index)) {
            res = Math.max(res, v.get(index) + dp(w, v, index - 1, c - w.get(index)));
        }
        return res;
    }
}
