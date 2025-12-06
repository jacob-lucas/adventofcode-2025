package com.jacoblucas.adventofcode2025.day06;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06 extends Day {
    private List<Problem> problems = new ArrayList<>();

    public Day06(final List<String> input) {
        List<String[]> puzzleInput = input.stream()
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
        problems = new ArrayList<>();
        try {
            final List<String> input = InputReader.read("day06-input.txt");

            int a = 0;
            int b = 1;
            int c = 2;
            int d = 3;
            int e = 4; // operator

            int lower = 0;
            for (int i = 0; i < input.getFirst().length(); i++) {
                char aCh = input.get(a).charAt(i);
                char bCh = input.get(b).charAt(i);
                char cCh = input.get(c).charAt(i);
                char dCh = input.get(d).charAt(i);
                char eCh = input.get(e).charAt(i);
                if ((aCh == bCh && aCh == cCh && aCh == dCh && aCh == eCh && aCh == ' ')) { // || i == input.get(0).length() - 1) {
                    System.out.println("Detected problem strings between at [" + lower + "-" + i + "]");

                    // parse problem
                    Problem problem = parseProblemInRange(input, lower, i, a, b, c, d, e);
                    problems.add(problem);
                    lower = i + 1;
                }
            }

            // grab the last one
            Problem problem = parseProblemInRange(input, lower, input.getFirst().length(), a, b, c, d, e);
            problems.add(problem);
        } catch (Throwable t) {
            // do nothing
            System.out.println(t.getMessage());
        }

        part1();
    }

    private static Problem parseProblemInRange(List<String> input, int lower, int upper, int a, int b, int c, int d, int e) {
        Problem problem = new Problem();
        for (int j = upper - 1; j >= lower; j--) {
            StringBuilder sb = new StringBuilder();
            sb.append(input.get(a).charAt(j));
            sb.append(input.get(b).charAt(j));
            sb.append(input.get(c).charAt(j));
            sb.append(input.get(d).charAt(j));
            problem.addArg(Integer.parseInt(sb.toString().trim()));
        }
        problem.setOperator(""+input.get(e).charAt(lower));
        return problem;
    }
}
