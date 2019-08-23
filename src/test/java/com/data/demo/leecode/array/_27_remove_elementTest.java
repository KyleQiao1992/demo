package com.data.demo.leecode.array;

import leecode.array._27_remove_element;
import org.junit.Test;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/8/21
 */
public class _27_remove_elementTest {

    @Test
    public void test() {
        int[] test = new int[]{3,2,2,3};
        int val = 3;
        _27_remove_element func = new _27_remove_element();
        func.removeElement(test, val);
    }
}