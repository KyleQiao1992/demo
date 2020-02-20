package leecode.bt_search_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _108_convert_sorted_array_to_binary_tree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        int top = (nums.length) - 1;
        int bottom = 0;
        int mid = -1;
        return dfs(bottom, top, mid, nums);
    }

    public static TreeNode dfs(int bottom, int top, int mid, int[] nums) {
        if (bottom > top) {
            return null;
        }
        mid = (bottom + top) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = dfs(bottom, mid - 1, mid, nums);
        temp.right = dfs(mid + 1, top, mid, nums);
        return temp;
    }

    public static void main(String[] args) {
        int[] a = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(a);
    }
}