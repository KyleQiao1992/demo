package leecode.array;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/5/14
 */
public class _485_max_conseccutive_ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
