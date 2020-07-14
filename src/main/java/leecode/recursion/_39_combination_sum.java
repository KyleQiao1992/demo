package leecode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _39_combination_sum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
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
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            p.add(candidates[i]);
            dfs(candidates, 0, p, target);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        _39_combination_sum f = new _39_combination_sum();
        List<List<Integer>> res = f.combinationSum(a, 7);
        System.out.println(res);
    }

}
