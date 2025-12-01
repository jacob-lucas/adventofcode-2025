package com.jacoblucas.adventofcode2025.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DialTest {
    private Dial dial;

    @BeforeEach
    public void init() {
        dial = new Dial(50, 100);
    }

    @Test
    public void testRightUnderCount() {
        int newValue = dial.turn(new TurnInstruction(Direction.RIGHT, 5));
        assertThat(newValue, is(55));
    }

    @Test
    public void testRightOverCount() {
        int newValue = dial.turn(new TurnInstruction(Direction.RIGHT, 51));
        assertThat(newValue, is(1));
    }

    @Test
    public void testLeftUnderCount() {
        int newValue = dial.turn(new TurnInstruction(Direction.LEFT, 5));
        assertThat(newValue, is(45));
    }

    @Test
    public void testLeftOverCount() {
        int newValue = dial.turn(new TurnInstruction(Direction.LEFT, 51));
        assertThat(newValue, is(99));
        newValue = dial.turn(new TurnInstruction(Direction.LEFT, 101));
        assertThat(newValue, is(98));
    }

    @Test
    public void testLeftOverMax1() {
        dial = new Dial(19, 100);
        int newValue = dial.turn(new TurnInstruction(Direction.LEFT, 943));
        assertThat(newValue, is(76));
    }

    @Test
    public void testLeftOverMax2() {
        dial = new Dial(5, 100);
        int newValue = dial.turn(new TurnInstruction(Direction.LEFT, 605));
        assertThat(newValue, is(0));
    }

    @Test
    public void testLeftOverMax3() {
        dial = new Dial(91, 100);
        int newValue = dial.turn(new TurnInstruction(Direction.LEFT, 343));
        assertThat(newValue, is(48));
    }
}
