package com.jacoblucas.adventofcode2025.day06;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06 extends Day {
    private final List<Problem> problems = new ArrayList<>();

    public Day06(final List<String> input) {
        final List<String[]> puzzleInput = input.stream()
                .map(str -> Arrays.stream(str.split(" ")).filter(s -> !s.isEmpty()).toArray(String[]::new))
                .toList();

        for (int i = 0; i < puzzleInput.size(); i++) {
            final String[] inputRow = puzzleInput.get(i);
            for (int j = 0; j < inputRow.length; j++) {
                if (i == 0) {
                    problems.add(new Problem());
                }
                try {
                    int n = Integer.parseInt(inputRow[j]);
                    problems.get(j).addArg(n);
                } catch (final NumberFormatException e) {
                    // add operator
                    problems.get(j).setOperator(inputRow[j]);
                }
            }
        }
    }

    static void main() throws IOException {
        final List<String> input = InputReader.read("day06-input.txt");
        Day06 day06 = new Day06(input);
        day06.executeWithTimer(day06::part1);
        day06.executeWithTimer(day06::part2);
    }

    @Override
    public void part1() {
        long total = problems.stream()
                .mapToLong(Problem::solve)
                .sum();

        System.out.println(total);
    }

    @Override
    public void part2() {

    }
}
