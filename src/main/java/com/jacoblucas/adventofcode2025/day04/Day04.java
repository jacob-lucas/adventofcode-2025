package com.jacoblucas.adventofcode2025.day04;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;
import com.jacoblucas.adventofcode2025.utils.IntPair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day04 extends Day {
    static final char ROLL = '@';
    static final char EMPTY = '.';

    private final char[][] grid;

    public Day04(char[][] grid) {
        this.grid = grid;
    }

    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day04-input.txt");
        final char[][] grid = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }

        Day04 day04 = new Day04(grid);
        day04.executeWithTimer(day04::part1);
        day04.executeWithTimer(day04::part2);
    }

    @Override
    public void part1() {
        System.out.println(totalAccessible(grid, false));
    }

    @Override
    public void part2() {
        int totalAccessible = 0;
        int accessible = Integer.MAX_VALUE;
        while (accessible > 0) {
            accessible = totalAccessible(grid, true);
            totalAccessible += accessible;
        }
        System.out.println(totalAccessible);
    }

    public static int totalAccessible(char[][] grid, boolean remove) {
        int accessibleCount = 0;
        List<IntPair> removalQueue = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ROLL && Day04.accessibleAt(grid, i, j, 4)) {
                    accessibleCount++;
                    if (remove) {
                        removalQueue.add(new IntPair(i, j));
                    }
                }
            }
        }
        removalQueue.forEach(pair -> grid[pair.left()][pair.right()] = EMPTY);
        return accessibleCount;
    }

    public static boolean accessibleAt(char[][] grid, int row, int col, int maxAdjacentCount) {
        int rollCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int x = row + i;
                int y = col + j;
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == ROLL) {
                    rollCount++;
                }
            }
        }
        return rollCount < maxAdjacentCount;
    }
}
