package leecode.array;

import java.util.HashMap;
import java.util.Map;

public class _3_Longest_Substring_Without_Repeating_Characters {

    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0, r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String testStr = "abcabcbb";
        lengthOfLongestSubstring(testStr);
    }
}