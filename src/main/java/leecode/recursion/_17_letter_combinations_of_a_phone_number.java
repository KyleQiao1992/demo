package leecode.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    // s中保存了此时从digits[0...index-1]翻译得到的得一个字母字符串
    // 寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
    private void findCombination(String digits, int index, String s) {
        System.out.println("index=" + index + ":" + s);
        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            System.out.println("digits[" + index + "] = " + c + ", use " + letters.charAt(i));
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digits[" + index + "] = " + c + " complete, return");
    }

    public static void main(String[] args) {
        String digits = "234";
        _17_letter_combinations_of_a_phone_number a = new _17_letter_combinations_of_a_phone_number();
        List<String> result = a.letterCombinations(digits);
    }

}
