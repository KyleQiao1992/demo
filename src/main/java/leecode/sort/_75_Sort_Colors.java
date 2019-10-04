package leecode.sort;

public class _75_Sort_Colors {
    //计数排序
    public static void sortColors(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int num : nums) {
            if (num == 0) {
                count1++;
            }
            if (num == 1) {
                count2++;
            }
            if (num == 2) {
                count3++;
            }
        }
        for (int i = 0; i < count1; i++) {
            nums[i] = 0;
        }
        for (int i = count1; i < count1 + count2; i++) {
            nums[i] = 1;
        }
        for (int i = count1 + count2; i < count1 + count2 + count3; i++) {
            nums[i] = 2;
        }
    }

    //三路快排序思路
    public static void sortColors2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        //注意边界问题
        //定义的是zero指向的是[0,zero] 注意这是一个闭区间 设置成一个无效的索引
        int zero = -1;
        //定义的是two指向的是[two,n-1] 这也是一个闭区间 同上
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, zero + 1, i);
                i++;
                zero++;
            } else {
                two--;
                swap(nums, two, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors2(a);
        sortColors(a);
    }
}
