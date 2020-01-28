package leecode.set_map;

import java.util.HashSet;
import java.util.Set;

public class _202_happy_number {
    public static boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> track = new HashSet<>();

        while (n != 1 && track.add(n)) {
            sum = 0;
            while (n != 0) {
                int k = n % 10;
                n = n / 10;
                sum += Math.pow(k, 2);
            }
            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}
