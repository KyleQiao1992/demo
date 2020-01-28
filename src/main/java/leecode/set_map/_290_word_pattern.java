package leecode.set_map;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _290_word_pattern {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] strList = str.split(" ");
        if (pattern.length() != strList.length) {
            return false;
        }
        //key:str value:pattern
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strList.length; i++) {
            String p = String.valueOf(pattern.charAt(i));
            String s = strList[i];
            if (!map.containsKey(s) && !set.contains(p)) {
                set.add(p);
                map.put(s, p);
            } else {
                String originP = map.get(s);
                if (!p.equals(originP)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        wordPattern(pattern, str);
    }
}
