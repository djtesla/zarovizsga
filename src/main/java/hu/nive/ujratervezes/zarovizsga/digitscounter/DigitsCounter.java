package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DigitsCounter {

    public static final List<Character> DIGITS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public int getCountOfDigits(String s) {
        Set<Character> differentDigits = new HashSet<>();
        if (s == null) {
            return 0;
        }
        for (char c : s.toCharArray()) {
            if (DIGITS.contains(c)) {
                differentDigits.add(c);
            }
        }
        return differentDigits.size();
    }


}
