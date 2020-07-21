package leecode.recursion;

import java.util.*;

public class _47_permutations_ii {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] usedList;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        usedList = new boolean[nums.length];
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> p) {
        if (p.size() == nums.length) {
            res.add(new LinkedList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!usedList[i]) {
                //后面和前面的数值相等，并且前面的数没有用过
                if (i > 0 && nums[i] == nums[i - 1] && !usedList[i - 1]) {
                    continue;
                }
                usedList[i] = true;
                p.add(nums[i]);
                dfs(nums, index + 1, p);
                usedList[i] = false;
                p.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        _47_permutations_ii f = new _47_permutations_ii();
        List<List<Integer>> res = f.permuteUnique(a);
        System.out.println(res);
    }
}
