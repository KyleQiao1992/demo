package com.data.demo.leecode;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/5/9
 */
public class _283_moveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

}
