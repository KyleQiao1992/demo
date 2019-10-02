package practice;

public class MergeSort2 {

    private static void merge(int[] arr, int left, int mid, int right) {
        int originArrLength = arr.length;
        int[] aux = new int[originArrLength];

    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        //分
        sort(arr, left, middle);
        sort(arr, middle + 1, right);
        //治
        merge(arr, left, middle, right);
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        sort(arr, 0, length - 1);
    }
}
