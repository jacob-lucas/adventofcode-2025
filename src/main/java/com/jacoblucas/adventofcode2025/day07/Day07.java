package com.jacoblucas.adventofcode2025.day07;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;
import com.jacoblucas.adventofcode2025.utils.IntPair;

import java.io.IOException;
import java.util.*;

public class Day07 extends Day {
    private final char[][] grid;

    public Day07(char[][] grid) {
        this.grid = grid;
    }

    static void main() throws IOException {
        final List<String> input = InputReader.read("day07-input.txt");
        final char[][] grid = Day07.toGrid(input);

        Day07 day07 = new Day07(grid);
        day07.executeWithTimer(day07::part1);
        day07.executeWithTimer(day07::part2);
    }

    static char[][] toGrid(final List<String> input) {
        char[][] grid = new char[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }
        return grid;
    }

    public int getSplitCount() {
        int row = 0;
        int col = 0;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] == 'S') {
                col = i;
                break;
            }
        }
        Map<IntPair, Integer> splitCoords = new HashMap<>();
        getSplitCountDfsHelper(grid, row, col, splitCoords);
        return splitCoords.size();
    }

    public int getSplitCountDfsHelper(final char[][] grid, int row, int col, Map<IntPair, Integer> splitCoords) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        } else if (grid[row][col] == '^') {
            // split!
            if (splitCoords.containsKey(new IntPair(row, col))) {
                return splitCoords.get(new IntPair(row, col));
            } else {
                splitCoords.put(new IntPair(row, col), splitCoords.size());
                return getSplitCountDfsHelper(grid, row, col - 1, splitCoords) + getSplitCountDfsHelper(grid, row, col + 1, splitCoords);
            }
        } else {
            // move down
            return getSplitCountDfsHelper(grid, row + 1, col, splitCoords);
        }
    }

    public long getSplitCountV2() {
        int row = 0;
        int col = 0;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] == 'S') {
                col = i;
                break;
            }
        }

        Map<IntPair, Long> splitCoords = new HashMap<>();
        return getSplitCountDfsHelperV2(grid, row, col, splitCoords);
    }

    public long getSplitCountDfsHelperV2(final char[][] grid, int row, int col, Map<IntPair, Long> splitCoords) {
        if (row >= grid.length || col >= grid[0].length) {
            return 1;
        } else if (grid[row][col] == '^') {
            // split!
            if (splitCoords.containsKey(new IntPair(row, col))) {
                return splitCoords.get(new IntPair(row, col));
            } else {
                long n = getSplitCountDfsHelperV2(grid, row, col - 1, splitCoords) + getSplitCountDfsHelperV2(grid, row, col + 1, splitCoords);
                splitCoords.put(new IntPair(row, col), n);
                return n;
            }
        } else {
            // move down
            return getSplitCountDfsHelperV2(grid, row + 1, col, splitCoords);
        }
    }

    @Override
    public void part1() {
        System.out.println(getSplitCount());
    }

    @Override
    public void part2() {
        System.out.println(getSplitCountV2());
    }
}
