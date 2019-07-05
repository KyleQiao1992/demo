package com.data.demo.leecode;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/5/10
 */
public class _566_reshape_the_matrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (r * c != m * n) {
            return nums;
        }
        int[][] reshapeNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshapeNums[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return reshapeNums;
    }
}

