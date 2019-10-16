package leecode.sort;

import java.util.Random;

public class _215_Kth_Largest_Element_in_an_Array {

    public static int findKthLargest(int[] nums, int k) {

    }

    private static int partition(int[] arr, int l, int r) {
        Random random = new Random();
        int randomIndex = random.nextInt(r - l + 1) + l;
        swap(arr, l, randomIndex);
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < arr[l]) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
