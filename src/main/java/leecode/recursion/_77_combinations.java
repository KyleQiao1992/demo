package leecode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77_combinations {
    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    //求解C(n,k),
    //当前已找到的组合存存储在c中，需要从start开始搜索新的元素
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            res.add((List<Integer>) c.clone());
            return;
        }

        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }

        return;
    }
}
