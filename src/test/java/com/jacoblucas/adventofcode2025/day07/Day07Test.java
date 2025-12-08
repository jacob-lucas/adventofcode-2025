package com.jacoblucas.adventofcode2025.day07;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

public class Day07Test {
    final static List<String> MANIFOLD = ImmutableList.of(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "..............."
    );

    @Test
    public void testSplitCount() {
        char[][] grid = Day07.toGrid(MANIFOLD);
        final Day07 day07 = new Day07(grid);
        assertThat(day07.getSplitCount(), is(21));
    }

    @Test
    public void testSplitCountV2() {
        char[][] grid = Day07.toGrid(MANIFOLD);
        final Day07 day07 = new Day07(grid);
        assertThat(day07.getSplitCountV2(), is(40L));
    }
}
