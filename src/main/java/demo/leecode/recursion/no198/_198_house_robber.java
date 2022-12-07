package demo.leecode.recursion.no198;

import java.util.Arrays;

public class _198_house_robber {

    // the max profit for robbing nums[i...n)
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    //考虑抢劫 nums[index...nums.size()]这个范围的所有的房子
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }

        return memo[index] =
                Math.max(tryRob(nums, index + 1),
                        nums[index] + tryRob(nums, index + 2));
    }

}
