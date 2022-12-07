package demo.leecode.set_map;

import java.util.ArrayList;
import java.util.HashMap;

public class _350_intersection_of_two_arrays_ii {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int num : nums1)
            if (!record.containsKey(num))
                record.put(num, 1);
            else
                record.put(num, record.get(num) + 1);

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int num : nums2)
            if (record.containsKey(num) && record.get(num) > 0) {
                result.add(num);
                record.put(num, record.get(num) - 1);
            }

        int[] ret = new int[result.size()];
        int index = 0;
        for (Integer num : result)
            ret[index++] = num;

        return ret;
    }
}
