package algorism.sort;

import java.util.Arrays;

public class MergeSort {

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //辅助空间，和当前要处理的空间一样大 size=r-l+1
        //之后，我们要做的事情是将当前的arr中所有的元素，全都复制到aux这个辅助空间中
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        //相当于这么写：
        /**
         * int[] aux = new int[r-l+1];
         *  //要把arr处理的元素 全都复制到aux中
         *  for(i=l;i<r;i++){
         *  //需要注意aux这个空间是从0开始的，但是arr这个空间是从l开始的
         *      aux[i-l]=arr[i];
         *  }
         */

        // 指向两个子数组开头的位置
        // 初始化，i指向左半部分的起始索引位置l；
        // j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            //索引不合法
            // 第三步，如果还没有遍历完，说明有半部分也就是j这部分还没有归并完成
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
                // 第四步，同理第三步
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;

                // 索引合法
                // 这个是处理的 第一步；
                // 这个辅助数组中i对应的元素（但是要注意，这个是有一个偏移量l的）是否小于j￿
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
                // 这里是处理的 第二步
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
                // 处理完第二步，需要注意的是此时，我们并没有考虑数组越界的问题
                // 我们能访问i-l和j-l，前提是i和j还在这两个数组相应的位置里
                // 但是，很有可能在算法运行到一定程度，i已经大于mid，此时运行第三步
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] arg) {
        Comparable[] a = new Comparable[]{8, 6, 2, 3, 1, 5, 7, 4};
        sort(a);
    }

}
