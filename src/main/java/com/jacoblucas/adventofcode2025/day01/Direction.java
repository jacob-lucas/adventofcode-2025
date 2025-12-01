package com.jacoblucas.adventofcode2025.day01;

import java.util.Optional;

public enum Direction {
    LEFT,
    RIGHT;

    public static Optional<Direction> of(final String input) {
        return switch (input) {
            case "L" -> Optional.of(LEFT);
            case "R" -> Optional.of(RIGHT);
            default -> Optional.empty();
        };
    }
}
