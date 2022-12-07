package demo.algorism.sort;

public class SeleteionSort {

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                // 使用compareTo方法比较两个Comparable对象的大小
                if( arr[j].compareTo( arr[minIndex] ) < 0 )
                    minIndex = j;

            swap( arr , i , minIndex);
        }
    }
    // 将i这个位置的元素，和j(我们找到的最小值的索引)元素进行交换
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
