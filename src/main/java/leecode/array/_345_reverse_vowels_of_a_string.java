package leecode.array;

import java.util.Arrays;
import java.util.List;

public class _345_reverse_vowels_of_a_string {

    public static String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        List<String> vowelsList = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
        char[] sChar = s.toCharArray();
        int l = 0;
        int r = sChar.length - 1;

        while (l <= r) {
            if (!vowelsList.contains(String.valueOf(sChar[l]))) {
                l++;
                continue;
            }

            if (!vowelsList.contains(String.valueOf(sChar[r]))) {
                r--;
                continue;
            }
            swap(sChar, l++, r--);
        }
        return String.valueOf(sChar);
    }

    private static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        String testStr = "leetcode";
        String result = reverseVowels(testStr);
    }
}
