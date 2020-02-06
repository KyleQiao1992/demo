package leecode.stack;

import java.util.Stack;

public class _150_evaluate_reverse_polish_notation {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> nums = new Stack<>();
        String valueStr = tokens[0];
        Integer result = 0;

        try {
            result = Integer.valueOf(valueStr);
        } catch (Exception e) {
        }

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Integer num1 = nums.pop();
                Integer num2 = nums.pop();
                switch (s) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                nums.push(result);
            } else {
                nums.push(Integer.valueOf(s));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] tokens = {"18"};
        evalRPN(tokens);
    }
}
