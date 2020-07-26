package leecode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Time Limit Exceeded
 * 解法是正确的但是超时了
 */
public class _70_climbing_stairs {
    public List<List<Integer>> res = new ArrayList<>();


    public int climbStairs(int n) {
        if (n <= 0) {
            return res.size();
        }
        List<Integer> list = Arrays.asList(1, 2);
        dfs(list, 0, new LinkedList<>(), n);
        return res.size();
    }

    private void dfs(List<Integer> list, Integer index, LinkedList<Integer> p, Integer n) {
        Integer sum = 0;
        for (Integer m : p) {
            sum += m;
        }
        if (sum == n) {
            res.add(new LinkedList<>(p));
            return;
        }
        if (sum > n) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            p.add(list.get(i));
            dfs(list, i + 1, p, n);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        _70_climbing_stairs f = new _70_climbing_stairs();
        Integer n = f.climbStairs(35);
        List<List<Integer>> lists = f.res;
    }
}
