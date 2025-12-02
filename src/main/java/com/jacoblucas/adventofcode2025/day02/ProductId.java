package com.jacoblucas.adventofcode2025.day02;

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
}
