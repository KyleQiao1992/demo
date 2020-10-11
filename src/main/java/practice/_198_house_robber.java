package practice;

import java.util.HashMap;
import java.util.Map;

public class _198_house_robber {
    Map<Integer, Integer> memo = new HashMap<>();


    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    private int dp(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int res = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + dp(nums, index + 2));
        }
        memo.put(index, res);
        return res;
    }


    public static void main(String[] args) {

    }
}
