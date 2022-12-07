package demo.leecode.array;

public class _125_Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        String original = s.replaceAll("[^A-Za-z0-9]", "");
        char[] sChar = original.toCharArray();
        int l = 0;
        int r = sChar.length - 1;
        while (l <= r) {
            String lStr = String.valueOf(sChar[l]);
            String rStr = String.valueOf(sChar[r]);
            if (lStr.equalsIgnoreCase(rStr)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String test = "A man, a plan, a canal: Panama";
        String test = "0P";
        boolean result = isPalindrome(test);
    }
}
