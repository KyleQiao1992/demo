package demo.leecode.array;

public class _344_Reverse_String {
    public static void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            if (s[l] == s[r]) {
                l++;
                r--;
                continue;
            }
            swap(s, l++, r--);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        char[] inputChar = {'h', 'e', 'l', 'l', 'o'};
        char[] inputChar = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(inputChar);
    }
}