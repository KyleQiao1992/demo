package com.data.demo.leecode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/5/9
 */
public class _283_moveZeroesTest {

    @Test
    public void test() {
        int[] array = {7, 7, 0, 0, 1, 3, 12};
        _283_moveZeroes test = new _283_moveZeroes();
        test.moveZeroes(array);
    }
}