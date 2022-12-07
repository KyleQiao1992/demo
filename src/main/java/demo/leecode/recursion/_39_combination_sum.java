package demo.leecode.recursion;

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

    private void dfs(int[] candidates, Integer index, LinkedList<Integer> p, int target) {
        Integer sum = 0;
        for (Integer t : p) {
            sum += t;
        }
        if (sum == target) {
            res.add(new LinkedList<>(p));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            //如果当前的元素 小于p的最后一个元素，就会出现 2 3 2；3，2，2；这种情况
            if (!p.isEmpty() && candidates[i] < p.getLast()) {
                continue;
            }
            p.add(candidates[i]);
            dfs(candidates, +1, p, target);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        _39_combination_sum f = new _39_combination_sum();
        int[] cadidates = {2, 3, 6, 7};
        List<List<Integer>> res = f.combinationSum(cadidates, 7);
        System.out.println(res);
    }

}
