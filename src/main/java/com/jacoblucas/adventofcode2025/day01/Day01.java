package com.jacoblucas.adventofcode2025.day01;

import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Day01 {
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

        final Dial dial = new Dial(50, 100);
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
}
