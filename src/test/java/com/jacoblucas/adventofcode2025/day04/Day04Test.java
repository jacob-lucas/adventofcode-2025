package com.jacoblucas.adventofcode2025.day04;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Day04Test {
    private static final char[][] TEST_GRID = new char[][] {
            {'.','.','@','@','.','@','@','@','@','.'},
            {'@','@','@','.','@','.','@','.','@','@'},
            {'@','@','@','@','@','.','@','.','@','@'},
            {'@','.','@','@','@','@','.','.','@','.'},
            {'@','@','.','@','@','@','@','.','@','@'},
            {'.','@','@','@','@','@','@','@','.','@'},
            {'.','@','.','@','.','@','.','@','@','@'},
            {'@','.','@','@','@','.','@','@','@','@'},
            {'.','@','@','@','@','@','@','@','@','.'},
            {'@','.','@','.','@','@','@','.','@','.'},
    };

    @Test
    public void testAccessibleAt() {
        assertThat(Day04.accessibleAt(TEST_GRID, 0,2,4), is(true));
        assertThat(Day04.accessibleAt(TEST_GRID, 0,3,4), is(true));
        assertThat(Day04.accessibleAt(TEST_GRID, 1,1,4), is(false));
        assertThat(Day04.accessibleAt(TEST_GRID, 1,2,4), is(false));
    }

    @Test
    public void testTotalAccessible() {
        assertThat(Day04.totalAccessible(TEST_GRID, false), is(13));
    }
}
