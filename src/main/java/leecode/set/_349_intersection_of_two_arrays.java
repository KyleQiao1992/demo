package leecode.set;

import java.util.*;

public class _349_intersection_of_two_arrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();
        for (Integer num : nums1) {
            num1Set.add(num);
        }
        for (Integer num : nums2) {
            num2Set.add(num);
        }
        //用其中小的一个遍历吧
        if (num1Set.size() <= num2Set.size()) {
            for (Integer num : num1Set) {
                if (num2Set.contains(num)) {
                    result.add(num);
                }
            }
        } else {
            for (Integer num : num2Set) {
                if (num1Set.contains(num)) {
                    result.add(num);
                }
            }
        }
        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        intersection(num1, num2);
    }
}
