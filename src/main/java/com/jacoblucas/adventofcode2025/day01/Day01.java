package com.jacoblucas.adventofcode2025.day01;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Day01 extends Day {
    private final List<TurnInstruction> turnInstructions;

    public Day01(List<TurnInstruction> turnInstructions) {
        this.turnInstructions = turnInstructions;
    }

    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day01-input.txt");
        final List<TurnInstruction> turnInstructions = input.stream()
                .map(i -> {
                    Optional<Direction> direction = Direction.of("" + i.charAt(0));
                    if (direction.isEmpty()) {
                        System.out.println("Cannot parse instruction input: " + i);
                        return null;
                    } else {
                        return new TurnInstruction(direction.get(), Integer.parseInt(i.substring(1)));
                    }
                })
                .filter(Objects::nonNull)
                .toList();

        Day01 day01 = new Day01(turnInstructions);
        day01.executeWithTimer(day01::part1);
        day01.executeWithTimer(day01::part2);
    }

    public void part1() {
        // Part 1
        Dial dial = new Dial(50, 100);
        int zeroCount = 0;
        for (final TurnInstruction turnInstruction : turnInstructions) {
            int currentValue = dial.getValue();
            int newValue = dial.turn(turnInstruction);
            System.out.println("The dial is rotated " + turnInstruction + " from " + currentValue + " to point at " + newValue);

            if (newValue == 0) {
                zeroCount++;
            }

            if (Math.abs(newValue) > dial.getCount()) {
                System.out.println("ERROR! Dial set to " + dial.getValue());
            }
        }
        System.out.println(zeroCount);
    }

    public void part2() {
        // Part 2
        Dial dial = new Dial(50, 100);
        int zeroCount = 0;
        for (final TurnInstruction turnInstruction : turnInstructions) {
            int currentValue = dial.getValue();
            int result = dial.turnV2(turnInstruction);
            int newValue = dial.getValue();
            zeroCount += result;
            System.out.println("The dial is rotated " + turnInstruction + " from " + currentValue + " to point at " + newValue + ", passing " + result + " times past 0.");

            if (Math.abs(newValue) > dial.getCount()) {
                System.out.println("ERROR! Dial set to " + dial.getValue());
            }
        }
        System.out.println(zeroCount);
    }
}
