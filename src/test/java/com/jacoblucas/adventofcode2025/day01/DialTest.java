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

    @Test
    public void testLeftZeroCountsNone() {
        int result = dial.turnV2(new TurnInstruction(Direction.LEFT, 49));
        assertThat(result, is(0));
        assertThat(dial.getValue(), is(1));
    }

    @Test
    public void testLeftZeroCountsNone2() {
        Dial d1 = new Dial(0, 100);
        int result = d1.turnV2(new TurnInstruction(Direction.LEFT, 99));
        assertThat(result, is(0));
        assertThat(d1.getValue(), is(1));
    }

    @Test
    public void testLeftZeroCountsOnce() {
        int result = dial.turnV2(new TurnInstruction(Direction.LEFT, 51));
        assertThat(result, is(1));
        assertThat(dial.getValue(), is(99));
    }

    @Test
    public void testLeftZeroCountsTwice() {
        int result = dial.turnV2(new TurnInstruction(Direction.LEFT, 151));
        assertThat(result, is(2));
        assertThat(dial.getValue(), is(99));
    }

    @Test
    public void testLeftZeroCounts3() {
        dial = new Dial(47, 100);
        int result = dial.turnV2(new TurnInstruction(Direction.LEFT, 247));
        // -47 hits 0 (200 left)
        // -100 hits 0 (100 left)
        // -100 hits 0 (0 left)
        assertThat(result, is(3));
        assertThat(dial.getValue(), is(0));
    }

    @Test
    public void testLeftZeroCounts10() {
        dial = new Dial(63, 100);
        int result = dial.turnV2(new TurnInstruction(Direction.LEFT, 959));
        // -59 does not hit 0 (900 left, on 4)
        // -100 hits 0 (800 left)
        // -100 hits 0 (700 left)
        // -100 hits 0 (600 left)
        // -100 hits 0 (500 left)
        // -100 hits 0 (400 left)
        // -100 hits 0 (300 left)
        // -100 hits 0 (200 left)
        // -100 hits 0 (100 left)
        // -100 hits 0 (0 left)
        // land on 4
        assertThat(result, is(9));
        assertThat(dial.getValue(), is(4));
    }

    @Test
    public void testRightZeroCountsNone() {
        int result = dial.turnV2(new TurnInstruction(Direction.RIGHT, 49));
        assertThat(result, is(0));
        assertThat(dial.getValue(), is(99));
    }

    @Test
    public void testRightZeroCountsNone2() {
        Dial d1 = new Dial(0, 100);
        int result = d1.turnV2(new TurnInstruction(Direction.RIGHT, 99));
        assertThat(result, is(0));
        assertThat(d1.getValue(), is(99));
    }

    @Test
    public void testRightZeroCountsOnce() {
        int result = dial.turnV2(new TurnInstruction(Direction.RIGHT, 51));
        assertThat(result, is(1));
        assertThat(dial.getValue(), is(1));
    }

    @Test
    public void testRightZeroCountsTwice() {
        int result = dial.turnV2(new TurnInstruction(Direction.RIGHT, 151));
        assertThat(result, is(2));
        assertThat(dial.getValue(), is(1));
    }
}
