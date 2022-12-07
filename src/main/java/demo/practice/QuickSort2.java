package demo.practice;

public class QuickSort2 {

    private static int partitionSimple(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void sortSimple(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partitionSimple(arr, l, r);
        sortSimple(arr, 0, p);
        sortSimple(arr, p + 1, r);
    }

    public static void sortSimple(int[] arr) {
        int length = arr.length;
        sortSimple(arr, 0, length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
