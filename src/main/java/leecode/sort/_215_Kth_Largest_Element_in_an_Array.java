package leecode.sort;

import java.util.Random;

public class _215_Kth_Largest_Element_in_an_Array {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private static int findKthLargest(int[] arr, int l, int r, int k) {
        if (l == r) {
            return arr[l];
        }

        int index = partition(arr, l, r);

        if (index == k) {
            return arr[index];
        } else if (k < index) {
            return findKthLargest(arr, l, index - 1, k);
        } else {
            return findKthLargest(arr, index + 1, r, k);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        Random random = new Random();
        int index = random.nextInt(r - l + 1) + l;
        swap(arr, l, index);
        int j = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] > arr[l]) {
                swap(arr, i, j++);
            }
        }
        swap(arr, l, j - 1);
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(arr, k);
    }
}
