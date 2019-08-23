package leecode.array;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/8/21
 */
public class _27_remove_element {

    public int removeElement(int[] nums, int val) {
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[value++] = nums[i];
            }
        }
        return value;
    }
}
