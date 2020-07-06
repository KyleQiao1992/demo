package practice;

import java.util.ArrayList;
import java.util.List;

public class _46_permutation {

    List<String> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        dfs(nums, 0, "");
        return null;
    }

    private void dfs(int[] nums, int index, String s) {
        System.out.println("index=" + index + ":" + s);

        if (index == nums.length) {
            res.add(s);
            System.out.println("__get : " + s);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("index=" + index + " use :" + nums[i]);
            dfs(nums, index + 1, s + nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        _46_permutation f = new _46_permutation();
        f.permute(a);
    }
}
