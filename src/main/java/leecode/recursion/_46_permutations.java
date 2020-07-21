package leecode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _46_permutations {

    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, 0, p);

        return res;
    }

    //p中保存了一个有index元素的排列
    //向这个排列的末尾添加第index+1个元素，获得一个有index+1的元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p) {
        System.out.println("__________index: " + index + ",p=" + p.toString());
        if (index == nums.length) {
            System.out.println("get result:" + ((LinkedList<Integer>) p.clone()).toString());
            res.add(new LinkedList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p);
                System.out.println("remove begin : nums = " + ((LinkedList<Integer>) p.clone()).toString() + " i=" + i);
                p.removeLast();
                used[i] = false;
            }
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = (new _46_permutations()).permute(nums);
        for (List<Integer> list : res) {
            printList(list);
        }
    }
}
