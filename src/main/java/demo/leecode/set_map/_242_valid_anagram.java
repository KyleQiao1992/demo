package demo.leecode.set_map;


import java.util.HashMap;
import java.util.Map;

public class _242_valid_anagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (!map1.containsKey(str)) {
                map1.put(str, 1);
            } else {
                Integer count = map1.get(str);
                map1.put(str, ++count);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            String str = String.valueOf(t.charAt(i));
            if (!map2.containsKey(str)) {
                map2.put(str, 1);
            } else {
                Integer count = map2.get(str);
                map2.put(str, ++count);
            }
        }

        for (String str : map1.keySet()) {
            Integer count1 = map1.get(str);
            Integer count2 = map2.get(str);
            if (count1 == null || count2 == null || (!count1.equals(count2))) {
                return false;
            }
        }
        return true;
}

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        isAnagram(s, t);
    }
}
