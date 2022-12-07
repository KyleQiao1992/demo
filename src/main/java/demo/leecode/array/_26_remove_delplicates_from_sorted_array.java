package demo.leecode.array;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/8/23
 */
public class _26_remove_delplicates_from_sorted_array {

    public int removeDuplicates(int[] nums) {
        int pPosition = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pPosition] != nums[i]) {
                nums[pPosition + 1] = nums[i];
                pPosition++;
            }
        }
        return pPosition + 1;
    }
}
