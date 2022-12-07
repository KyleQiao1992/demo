package demo.practice;

public class MergeSort2 {

    public void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i < r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k < r; k++) {
            //左边已经遍历完成，只需要把右边的数组赋值k即可
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //右边的数组已经遍历完成
                arr[k] = aux[i - l];
                i++;
            }

            if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, 0, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void sort(int[] arr) {
        int length = arr.length;
        sort(arr, 0, length - 1);
    }
}
