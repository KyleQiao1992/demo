package demo.leecode.greedy_algorithm;

import java.util.Arrays;

public class _455_assign_cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length - 1, si = s.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
            }
            gi--;
        }
        return res;
    }

}
