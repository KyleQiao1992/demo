package demo.leecode.set_map;

import java.util.HashMap;

public class _447_number_of_boomeranges {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {

            // record中存储 点i 到所有其他点的距离出现的频次
            //key:距离, value:频率
            HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++)
                if (j != i) {
                    // 计算距离时不进行开根运算, 以保证精度
                    int dis = dis(points[i], points[j]);
                    if (record.containsKey(dis))
                        record.put(dis, record.get(dis) + 1);
                    else
                        record.put(dis, 1);
                }

            for (Integer dis : record.keySet())
                res += record.get(dis) * (record.get(dis) - 1);
        }

        return res;
    }

    private int dis(int[] pa, int[] pb) {
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) +
                (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

}
