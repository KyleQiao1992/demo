package demo.leecode.set_map;

import java.util.*;

public class _451_sort_characters_by_frequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                Integer count = map.get(str);
                map.put(str, ++count);
            }
        }
        List<Map.Entry<String, Integer>> list = sortByValue(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> countMap : list) {
            String key = countMap.getKey();
            Integer value = countMap.getValue();
            for (int i = 0; i < value; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }

    private static List<Map.Entry<String, Integer>> sortByValue(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        //注意 ArrayList<>() 括号里要传入map.entrySet()
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();

                //按照value值，从大到小排序
                return o2.getValue() - o1.getValue();

                //按照value值，用compareTo()方法默认是从小到大排序
//                return o1.getValue().compareTo(o2.getValue());
            }
        });
        return list;
    }

    public static void main(String[] args) {
        String s = "treesdhjasdhsajkdhaskhdsak";
        frequencySort(s);
    }
}
