package demo.leecode.dymamic_programming.no416;

public class partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            sum += nums[i];
        }

        if (sum % 2 == 1)
            return false;

        int n = nums.length;
        int C = sum / 2;

        boolean[] memo = new boolean[C + 1];
        for (int i = 0; i <= C; i++)
            memo[i] = (nums[0] == i);

        for (int i = 1; i < n; i++)
            for (int j = C; j >= nums[i]; j--)
                memo[j] = memo[j] || memo[j - nums[i]];

        return memo[C];
    }
}
