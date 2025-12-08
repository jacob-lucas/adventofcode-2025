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

    public static int getSplitCount(final char[][] grid) {
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

    public static int getSplitCountDfsHelper(final char[][] grid, int row, int col, Map<IntPair, Integer> splitCoords) {
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

    @Override
    public void part1() {
        System.out.println(getSplitCount(grid));
    }

    @Override
    public void part2() {

    }
}
