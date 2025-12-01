package com.jacoblucas.adventofcode2025.day01;

public class Dial {
    private int value;
    private final int count;

    public Dial(final int startingValue, final int count) {
        this.value = startingValue;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public int turn(TurnInstruction turnInstruction) {
        if (turnInstruction.direction() == Direction.LEFT) {
            int currentValue = value;
            int turn = turnInstruction.value() > count ? turnInstruction.value() % count : turnInstruction.value();
            if (turn > currentValue) {
                value = count - (turn - currentValue);
                if (value == count) {
                    value = 0;
                }
            } else {
                value = value - turn;
            }
        } else {
            value = (value + turnInstruction.value()) % count;
        }
        return value;
    }
}
