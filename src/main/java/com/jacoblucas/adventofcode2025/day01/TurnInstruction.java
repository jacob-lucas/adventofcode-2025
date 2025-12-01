package com.jacoblucas.adventofcode2025.day01;

public record TurnInstruction(Direction direction, int value) {
    @Override
    public String toString() {
        return direction.name().charAt(0) + Integer.toString(value);
    }
}
