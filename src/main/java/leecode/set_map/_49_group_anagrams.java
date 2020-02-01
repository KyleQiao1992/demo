package leecode.set_map;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

public class _49_group_anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strCharList = strs[i].toCharArray();
            Arrays.sort(strCharList);
            String key = String.valueOf(strCharList);
            if (!map.containsKey(key)) {
                List<String> array = new ArrayList<>();
                array.add(strs[i]);
                map.put(key, array);
            } else {
                List<String> list = map.get(key);
                list.add(String.valueOf(strs[i]));
                map.put(key, list);
            }
        }
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}
