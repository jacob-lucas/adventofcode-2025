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
        assertThat(Day07.getSplitCount(grid), is(21));
    }
}
