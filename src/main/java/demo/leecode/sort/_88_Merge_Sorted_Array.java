package demo.leecode.sort;

public class _88_Merge_Sorted_Array {

    //使用辅助空间
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int[] result = new int[m + n];
        int point1 = 0;
        int point2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (point1 < m && point2 < n && nums1[point1] < nums2[point2]) {
                result[i] = nums1[point1++];
            } else if (point2 < n) {
                result[i] = nums2[point2++];
            } else {
                result[i] = nums1[point1++];
            }
        }
        System.arraycopy(result, 0, nums1, 0, nums1.length);
    }

    //不使用辅助空间，从后向前遍历
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        int point1 = m - 1;
        int point2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {

            if (point1 >= 0 && point2 >= 0 && nums1[point1] > nums2[point2]) {
                nums1[i] = nums1[point1];
                point1--;
            } else if (point2 >= 0) {
                nums1[i] = nums2[point2];
                point2--;
            } else {
                nums1[i] = nums1[point1];
                point1--;
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge2(num1, 3, num2, 3);
        merge(num1, 0, num2, 1);
    }
}
