package demo.leecode.array;

public class _167_Two_Sum_II {
    //暴力解法
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    //二分查找法
    public static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length <= 0) {
            return result;
        }
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target == numbers[mid] + numbers[i]) {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                }
                if (target > numbers[mid] + numbers[i]) {
                    l = mid + 1;
                } else {
                    //target<number[mid]
                    r = mid - 1;
                }
            }
        }
        return result;
    }

    //对撞指针
    public static int[] twoSum3(int[] numbers, int target) {
        int[] result = new int[2];
        int j = numbers.length - 1;
        for (int i = 0; i < j; ) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1,0};
        int[] result = twoSum(array, 26);
        int[] result2 = twoSum2(array, 26);
        int[] result3 = twoSum3(array, -1);
        int a = 0;
    }
}
