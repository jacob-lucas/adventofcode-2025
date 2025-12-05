package com.jacoblucas.adventofcode2025.day05;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day05 extends Day {
    private final List<Range> ranges;
    private final List<Long> availableIngredientIds;

    public Day05(List<Range> ranges, List<Long> availableIngredientIds) {
        this.ranges = ranges;
        this.availableIngredientIds = availableIngredientIds;
    }

    public static void main(String[] args) throws IOException {
        final List<List<String>> inputs = InputReader.readGroups("day05-input.txt");

        final List<Range> ranges = inputs.get(0).stream()
                .map(str -> str.split("-"))
                .map(strs -> new Range(Long.parseLong(strs[0]), Long.parseLong(strs[1]), true))
                .toList();

        final List<Long> availableIngredientIds = inputs.get(1).stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .toList();

        Day05 day05 = new Day05(ranges, availableIngredientIds);
        day05.executeWithTimer(day05::part1);
        day05.executeWithTimer(day05::part2);
    }

    public static List<Range> reduceRanges(List<Range> ranges) {
        List<Range> sorted = new ArrayList<>(ranges.stream()
                .sorted(Comparator.comparing(Range::lower))
                .toList());

        int i = 0;
        while (i < sorted.size() - 1) {
            Range curr =  sorted.get(i);
            Range next = sorted.get(i + 1);
            if (curr.upper() < next.lower()) {
                // no overlap
                i++;
            } else {
                // reduce
                Range reduced = new Range(
                        Math.min(curr.lower(), curr.upper()),
                        Math.max(curr.upper(), next.upper()),
                        true);
                sorted.set(i, reduced);
                sorted.remove(i + 1);
            }
        }

        return sorted;
    }

    @Override
    public void part1() {
        long freshIngredientCount = availableIngredientIds.stream()
                .filter(id -> ranges.stream().anyMatch(range -> range.includes(id)))
                .count();
        System.out.println(freshIngredientCount);
    }

    @Override
    public void part2() {
        List<Range> reduced = reduceRanges(ranges);
        long inventoryCount = reduced.stream()
                .mapToLong(Range::count)
                .sum();
        System.out.println(inventoryCount);
    }
}
