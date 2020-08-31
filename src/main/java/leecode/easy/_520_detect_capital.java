package leecode.easy;

public class _520_detect_capital {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] wordChar = word.toCharArray();
        Integer capitalWordCnt = 0;
        for (char w : wordChar) {
            if (w >= 'A' && w <= 'Z') {
                capitalWordCnt++;
            }
        }
        if (capitalWordCnt == 0 || capitalWordCnt == wordChar.length) {
            return true;
        }
        if (capitalWordCnt == 1 && (wordChar[0] >= 'A' && wordChar[0] <= 'Z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _520_detect_capital f = new _520_detect_capital();
        boolean res1 = f.detectCapitalUse("USA");
        boolean res2 = f.detectCapitalUse("leetcode");
        boolean res3 = f.detectCapitalUse("Google");
        boolean res4 = f.detectCapitalUse("FlaG");
    }
}
