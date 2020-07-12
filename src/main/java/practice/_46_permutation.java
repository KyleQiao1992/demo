package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _46_permutation {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] usedList;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        usedList = new boolean[nums.length];
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> p) {
        if (p.size() == nums.length) {
            res.add((LinkedList<Integer>)p.clone());
        }

        for (int i = 0; i < nums.length; i++) {
            if (!usedList[i]) {
                usedList[i] = true;
                p.add(nums[i]);
                dfs(nums, index + 1, p);
                usedList[i] = false;
                p.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        _46_permutation f = new _46_permutation();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = f.permute(nums);
    }
}
