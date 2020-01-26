package leecode.set_map;


import java.util.HashMap;
import java.util.Map;

public class _1_two_sum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            }
            record.put(nums[i], i);
        }
        return new int[0];
    }
}
