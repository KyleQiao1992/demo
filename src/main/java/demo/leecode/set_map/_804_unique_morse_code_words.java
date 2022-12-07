package demo.leecode.set_map;

import java.util.HashSet;
import java.util.Set;

public class _804_unique_morse_code_words {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseList = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        if (words == null || words.length == 0) {
            return 0;
        }
        Set<String> result = new HashSet<>();
        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String tmp = morseList[word.charAt(i) - 'a'];
                morse.append(tmp);
            }
            result.add(morse.toString());
        }
        return result.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int result = uniqueMorseRepresentations(words);
    }

}
