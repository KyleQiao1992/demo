package demo.leecode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _78_subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> p) {
        if (p.size() <= nums.length) {
            res.add(new LinkedList<>(p));
        }

        for (int i = index; i < nums.length; i++) {
            p.add(nums[i]);
            dfs(nums, i + 1, p);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        _78_subsets f = new _78_subsets();
        List<List<Integer>> res = f.subsets(num);
        System.out.println(res);
    }
}
