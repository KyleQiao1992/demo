package leecode.set_map;

import java.util.TreeSet;

public class _220_contains_duplicate_iii {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0)
            return false;
        TreeSet<Long> record = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {

            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;

            record.add((long) nums[i]);

            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }
        return false;
    }
}
