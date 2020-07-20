package leecode.recursion;

import java.util.*;

public class _40_combination_sum_ii {
    HashSet<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, new LinkedList<>(), target);
        return new ArrayList<>(res);
    }

    private void dfs(int[] candidates, Integer index, LinkedList<Integer> p, int target) {
        Integer sum = 0;
        for (Integer s : p) {
            sum += s;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new LinkedList<>(p));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (!p.isEmpty() && candidates[i] < p.getLast()) {
                continue;
            }
            p.add(candidates[i]);
            dfs(candidates, i + 1, p, target);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        _40_combination_sum_ii f = new _40_combination_sum_ii();
        int[] candidates = {2,5,2,1,2};
        List<List<Integer>> res = f.combinationSum2(candidates, 5);
        System.out.println(res);
    }

}
