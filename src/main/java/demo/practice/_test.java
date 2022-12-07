package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _test {

    public List<Integer> res(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        Integer posiAndXZeroCount = 0;
        Integer negaCount = 0;
        for (Integer num : list) {
            if (num >= 0) {
                posiAndXZeroCount++;
            } else {
                negaCount++;
            }
        }
        //正-负-正-负 型
        if (posiAndXZeroCount >= 0) {
            Integer posiIndex = 0;
            Integer negaIndex = 0;
            while (negaIndex < list.size()) {
                Integer getPositiveIndex = getPositiveIndex(posiIndex, list);
                Integer getNegaIndex = getNegativeIndex(negaIndex, list);
                if (getPositiveIndex == -1 || getNegaIndex == -1) {
                    break;
                }
                swap(list, getPositiveIndex + 1, getNegaIndex);

                posiIndex = posiIndex + 2;
                negaIndex = negaIndex + 2;
            }
        }

        //负-正-负-正 型
        if (posiAndXZeroCount < 0) {
            //略 完全相反
        }
        return list;
    }

    private void swap(List<Integer> list, Integer start, Integer end) {
        Integer temp = list.get(end);
        list.set(end, list.get(start));
        list.set(start, temp);
    }

    private Integer getPositiveIndex(Integer startIndex, List<Integer> list) {
        for (int i = startIndex; i < list.size(); i++) {
            if (list.get(i) >= 0) {
                return i;
            }
        }
        return -1;
    }

    private Integer getNegativeIndex(Integer startIndex, List<Integer> list) {
        for (int i = startIndex; i < list.size(); i++) {
            if (list.get(i) < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(6, 7, 8, -2, -3);
        _test f = new _test();
        f.res(test);
    }
}
