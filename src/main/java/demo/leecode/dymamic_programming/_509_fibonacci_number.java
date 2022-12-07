package demo.leecode.dymamic_programming;

import java.util.HashMap;
import java.util.Map;

public class _509_fibonacci_number {
    Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public int fib2(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        if (!memo.containsKey(N)) {
            memo.put(N, fib(N - 1) + fib(N - 2));
        }
        return memo.get(N);
    }

    public int fib3(int N) {
        memo.put(0, 0);
        memo.put(1, 1);

        for (int i = 2; i <= N; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(N);
    }

    public static void main(String[] args) {
        _509_fibonacci_number f = new _509_fibonacci_number();
        Integer res = f.fib3(4);
        System.out.println(res);
    }

}
