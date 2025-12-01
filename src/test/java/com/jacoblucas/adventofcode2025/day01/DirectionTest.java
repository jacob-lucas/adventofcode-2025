package com.jacoblucas.adventofcode2025.day01;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {
    @Test
    public void testLeft() {
        assertThat(Direction.of("L").get(), is(Direction.LEFT));
    }

    @Test
    public void testRight() {
        assertThat(Direction.of("R").get(), is(Direction.RIGHT));
    }

    @Test
    public void testUnknown() {
        assertThat(Direction.of("Q").isEmpty(), is(true));
    }
}
