package leecode.set_map;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class _219_contains_duplicate_ii {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() == k + 1) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
