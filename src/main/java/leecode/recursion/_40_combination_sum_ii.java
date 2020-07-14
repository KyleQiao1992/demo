package leecode.recursion;

import data_structure.list.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _40_combination_sum_ii {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.asList(candidates);
        dfs(candidates, 0, new LinkedList<>(), target);
        return res;
    }

    private void dfs(int[] candidates, int index, LinkedList<Integer> p, int target) {
        Integer sum = 0;
        for (Integer x : p) {
            sum += x;
        }
        if (sum == target) {
            res.add((List<Integer>) p.clone());
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            p.add(candidates[i]);
            dfs(candidates, i + 1, p, target);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] ca = {10, 1, 2, 7, 6, 1, 5};
        _40_combination_sum_ii f = new _40_combination_sum_ii();
        List<List<Integer>> res = f.combinationSum2(ca, 8);
        System.out.println(res);
    }
}
