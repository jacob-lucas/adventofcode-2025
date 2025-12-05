package com.jacoblucas.adventofcode2025.day05;

public record Range(long lower, long upper, boolean inclusive) {
    public boolean includes(long n) {
        if (inclusive) {
            return n >= lower && n <= upper;
        } else {
            return n > lower && n < upper;
        }
    }

    public long count() {
        return upper - lower + 1;
    }
}
