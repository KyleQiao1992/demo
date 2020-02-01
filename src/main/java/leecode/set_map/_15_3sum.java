package leecode.set_map;

import java.util.*;

public class _15_3sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 1) {
            return result;
        }

        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer sum = nums[i] + nums[j];
                List<Integer> tmpList = Arrays.asList(i, j);
                Set<List<Integer>> set = map.get(sum);
                if (set == null || set.isEmpty()) {
                    set = new HashSet<>();
                }
                set.add(tmpList);
                map.put(sum, set);
            }
        }
        Set<List<Integer>> setResult = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer difference = 0 - nums[i];
            Set<List<Integer>> set = map.get(difference);
            if (set != null && !set.isEmpty()) {
                for (List<Integer> list : set) {
                    if (!list.contains(i)) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[list.get(0)], nums[list.get(1)]);
                        Collections.sort(tmp);
                        setResult.add(tmp);
                    }
                }
            }
        }
        result.addAll(setResult);
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3)
            return new ArrayList<>();
        HashSet<List<Integer>> triples = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            findTriples(nums, i, triples);
        }
        return new ArrayList<> (triples);
    }

    private void findTriples(int[] nums, int index, HashSet<List<Integer>> triples) {
        int sum = (-1) * nums[index++];
        int end = nums.length - 1;
        while(index < end) {
            int curSum = nums[index] + nums[end];
            if (curSum == sum) {
                triples.add(Arrays.asList(-sum, nums[index], nums[end]));
                index++;
                end--;
            } else if(curSum < sum) {
                index++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
}
