package demo.leecode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216_combination_sum_iii {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(i + 1);
        }
        dfs(list, 0, new LinkedList<>(), k, n);
        return res;
    }

    private void dfs(List<Integer> list, Integer index, LinkedList<Integer> p, int k, int n) {
        if (p.size() == k) {
            Integer sum = 0;
            for (Integer s : p) {
                sum += s;
            }
            if (sum == n) {
                res.add(new LinkedList<>(p));
                return;
            }
            if (sum > n) {
                return;
            }
        }

        for (int i = index; i < list.size(); i++) {
            if (!p.isEmpty() && list.get(i) <= p.getLast()) {
                continue;
            }
            p.add(list.get(i));
            dfs(list, index + 1, p, k, n);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        _216_combination_sum_iii f = new _216_combination_sum_iii();
        List<List<Integer>> res = f.combinationSum3(3, 7);
        System.out.println(res);
    }
}
