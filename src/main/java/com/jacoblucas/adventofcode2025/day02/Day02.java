package com.jacoblucas.adventofcode2025.day02;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 extends Day {
    private final List<ProductIdRange> productIdRanges;

    public Day02(List<ProductIdRange> productIdRanges) {
        this.productIdRanges = productIdRanges;
    }

    public static void main(String[] args) throws IOException {
        final String input = InputReader.read("day02-input.txt").get(0);

        final List<ProductIdRange> productIdRanges = Arrays.stream(input.split(","))
                .map(ProductIdRange::parse)
                .toList();

        Day02 day02 = new Day02(productIdRanges);
        day02.executeWithTimer(day02::part1);
        day02.executeWithTimer(day02::part2);
    }

    @Override
    public void part1() {
        // Part 1
        List<ProductId> invalidProductIds = new ArrayList<>();
        for (final ProductIdRange productIdRange : productIdRanges) {
            final List<ProductId> invalid = productIdRange.stream()
                    .filter(p -> !p.isValid())
                    .toList();
            System.out.println("Invalid product IDs in range " + productIdRange + " are: " + invalid);
            invalidProductIds.addAll(invalid);
        }

        long idSum = invalidProductIds.stream().mapToLong(ProductId::id).sum();
        System.out.println(idSum);
    }

    @Override
    public void part2() {
        // Part 2
        List<ProductId> invalidProductIds = new ArrayList<>();
        for (final ProductIdRange productIdRange : productIdRanges) {
            final List<ProductId> invalid = productIdRange.stream()
                    .filter(p -> !p.isValidV2())
                    .toList();
            System.out.println("Invalid product IDs in range " + productIdRange + " are: " + invalid);
            invalidProductIds.addAll(invalid);
        }

        long idSum = invalidProductIds.stream().mapToLong(ProductId::id).sum();
        System.out.println(idSum);
    }
}
