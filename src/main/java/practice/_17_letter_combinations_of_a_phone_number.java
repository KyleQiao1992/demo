package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _17_letter_combinations_of_a_phone_number {
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if (digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    //digits: 输入的字符串
    //index: digits的索引
    //s: 暂时处理的字符
    private void findCombination(String digits, int index, String s) {
        System.out.println("index:" + index + ",s=" + s);
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
//            "abc",  //2
//            "def",  //3
//            "ghi",  //4

        //获取按键所对应的字符串，比如，按 234 这里是获取2
        char num = digits.charAt(index);
        //获取字符串组，比如2对应的是abc
        String letters = letterMap[num - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digits[" + index + "] = " + num + " complete, return");
        return;
    }

    public static void main(String[] args) {
        _17_letter_combinations_of_a_phone_number f = new _17_letter_combinations_of_a_phone_number();
        f.letterCombinations("234");
    }
}
