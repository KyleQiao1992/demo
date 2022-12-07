package demo.leecode.recursion.no300;

import java.util.Arrays;

public class longest_increasing_subsequence {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for (int i = 0; i < nums.length; i++)
            res = Math.max(res, getMaxLength(nums, i));

        return res;
    }

    // 以 nums[index] 为结尾的最长上升子序列的长度
    private int getMaxLength(int[] nums, int index) {

        if (memo[index] != -1)
            return memo[index];

        int res = 1;
        for (int i = 0; i <= index - 1; i++)
            if (nums[index] > nums[i])
                res = Math.max(res, 1 + getMaxLength(nums, i));

        return memo[index] = res;
    }
}
