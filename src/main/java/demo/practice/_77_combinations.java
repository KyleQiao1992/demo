package demo.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77_combinations {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || k > n) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        dfs(list, 0, new LinkedList<>(), k);
        return res;
    }

    private void dfs(List<Integer> list, int index, LinkedList<Integer> p, int k) {
        if (p.size() == k) {
            res.add((List<Integer>) p.clone());
            return;
        }
        for (int i = index; i < list.size(); i++) {
            p.add(list.get(i));
            dfs(list, i + 1, p, k);
            p.remove(p.size() - 1);
        }
    }

    public static void main(String[] args) {
        _77_combinations f = new _77_combinations();
        List<List<Integer>> res = f.combine(4, 2);
        System.out.println(res);
    }
}
