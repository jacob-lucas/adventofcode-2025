package com.jacoblucas.adventofcode2025.day06;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private final List<Integer> args;
    private char operator;

    public Problem() {
        this.args = new ArrayList<>();
    }

    public void addArg(final int i) {
        args.add(i);
    }

    public long solve() {
        if (operator == '+') {
            return args.stream()
                    .mapToLong(Long::valueOf)
                    .sum();
        } else if (operator == '*') {
            return args.stream()
                    .mapToLong(Long::valueOf)
                    .reduce(1, (a, b) -> a * b);
        } else {
            System.out.println("Unsupported operator: " + operator);
            return -1;
        }
    }

    public void setOperator(String s) {
        operator = s.charAt(0);
    }
}
