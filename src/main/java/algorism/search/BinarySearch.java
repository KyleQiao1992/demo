package algorism.search;

public class BinarySearch {

    public static int search(int[] arr, int target) {
        if (arr.length < 1) {
            return -1;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                //target<arr[mid]
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
