package demo.leecode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _90_subsets_ii {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> p) {
        if (p.size() <= nums.length) {
            res.add(new LinkedList<>(p));
        }

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            p.add(nums[i]);
            dfs(nums, i + 1, p);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        _90_subsets_ii f = new _90_subsets_ii();
        List<List<Integer>> res = f.subsetsWithDup(nums);
        System.out.println(res);
    }
}
