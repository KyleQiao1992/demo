package demo.leecode.array;

public class _209_Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1;
        int sum = 0;
        int res = -1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        return res == -1 ? 0 : res;
    }
}
