package leecode.easy;

public class _7_reverse_integer {
    public int reverse(int x) {
        int flag = 1;
        Long res = 0L;
        if (x < 0) {
            flag = -1;
        }
        x = Math.abs(x);
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        res = res * flag;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return res.intValue();
    }

    public static void main(String[] args) {
        _7_reverse_integer a = new _7_reverse_integer();
        int result = a.reverse(1534236469);
    }
}
