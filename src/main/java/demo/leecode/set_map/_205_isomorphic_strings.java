package demo.leecode.set_map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _205_isomorphic_strings {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        //key:s value:t
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            String t1 = String.valueOf(t.charAt(i));
            if (!map.containsKey(s1) && !set.contains(s1) && !set.contains(t1)) {
                set.add(s1);
                set.add(t1);
                map.put(s1, t1);
            } else {
                String t2 = map.get(s1);
                if (!t1.equals(t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (map.containsKey(ss)) {
                if (map.get(ss) != tt) return false;
            } else {
                if (map.containsValue(tt)) return false;
                map.put(ss, tt);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        isIsomorphic2(s, t);
    }
}
