package leecode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _387_first_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        Map<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (strMap.containsKey(str)) {
                Integer count = strMap.get(str);
                strMap.put(str, ++count);
            } else {
                strMap.put(str, 1);
            }
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            int count = strMap.get(str);
            if (count == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        _387_first_unique_character_in_a_string a = new _387_first_unique_character_in_a_string();
        int result = a.firstUniqChar(s);
    }
}
