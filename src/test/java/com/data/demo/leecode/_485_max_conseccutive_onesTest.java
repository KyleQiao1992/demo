package com.data.demo.leecode;

import leecode.array._485_max_conseccutive_ones;
import org.junit.Test;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/5/22
 */
public class _485_max_conseccutive_onesTest {
    @Test
    public void testFindMaxConsecutiveOnes() {
        _485_max_conseccutive_ones service = new _485_max_conseccutive_ones();
        int[] array = {1, 1, 0, 1, 1, 1};
        service.findMaxConsecutiveOnes(array);
    }
}