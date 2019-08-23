package leecode.stack;

import java.util.Stack;

/**
 * @author: qiaoyi
 * @edit:
 * @created:2019/7/16
 */
public class _1047_Remove_All_Adjacent_Duplicates_In_String {

    public String removeDuplicates(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String inChar = String.valueOf(S.charAt(i)) ;
            if (stack.isEmpty()) {
                stack.push(inChar);
                continue;
            }
            String topChar = stack.peek();
            //如果栈顶元素==将要入栈元素
            if (inChar.equals(topChar)) {
                stack.pop();
            } else {
                stack.push(inChar);
            }
        }

        return String.join("",stack);
    }

}
