package com.jacoblucas.adventofcode2025.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record ProductId(long id) {

    // looking for any ID which is made only of some sequence of digits repeated twice.
    // So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice) would all be invalid IDs.
    // None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a valid ID that you would ignore.)
    public boolean isValid() {
        final String idString = Long.toUnsignedString(id);
        if (idString.length() % 2 != 0) {
            return true;
        }

        String left = idString.substring(0, idString.length() / 2);
        String right = idString.substring(idString.length() / 2);
        return !left.equals(right);
    }

    // an ID is invalid if it is made only of some sequence of digits repeated at least twice.
    public boolean isValidV2() {
        String regex = "(.+)\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(""+id);
        return !matcher.matches();
    }
}
