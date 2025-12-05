package com.jacoblucas.adventofcode2025.day05;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

public class Day05Test {
    private final List<Range> ranges = ImmutableList.of(
            new Range(3, 5, true),
            new Range(21, 22, true),
            new Range(10, 14, true),
            new Range(20, 25, true),
            new Range(16, 20, true),
            new Range(12, 18, true),
            new Range(2159067702268L, 4787696298952L, true),
            new Range(4787696298954L, 9540471110793L, true)
    );

    @Test
    public void testReduceRanges() {
        assertThat(Day05.reduceRanges(ranges), is(ImmutableList.of(
                new Range(3, 5, true),
                new Range(10, 25, true),
                new Range(2159067702268L, 4787696298952L, true),
                new Range(4787696298954L, 9540471110793L, true)
        )));
    }

    @Test
    public void testCount() {
        assertThat(new Range(10, 14, true).count(), is(5L));
    }
}
