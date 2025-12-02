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

    // You remember from the training seminar that "method 0x434C49434B" means you're actually supposed to count the
    // number of times any click causes the dial to point at 0, regardless of whether it happens during a rotation
    // or at the end of one.
    public int turnV2(TurnInstruction turnInstruction) {
        int div = turnInstruction.value() / count;
        int mod = turnInstruction.value() % count;

        int result = 0;
        if (mod >= (value == 0 ? 100 : value) && turnInstruction.direction() == Direction.LEFT) {
            result++;
        } else if (mod >= (count - value) && turnInstruction.direction() == Direction.RIGHT) {
            result++;
        }

        turn(turnInstruction);

        return result + div;
    }
}
