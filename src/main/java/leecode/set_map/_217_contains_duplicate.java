package leecode.set_map;

import java.util.HashSet;
import java.util.Set;

public class _217_contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        containsDuplicate(nums);
    }
}
