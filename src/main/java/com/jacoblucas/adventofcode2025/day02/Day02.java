package com.jacoblucas.adventofcode2025.day02;

import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 {
    public static void main(String[] args) throws IOException {
        final String input = InputReader.read("day02-input.txt").get(0);

        final List<ProductIdRange> productIdRanges = Arrays.stream(input.split(","))
                .map(ProductIdRange::parse)
                .toList();

        // Part 1
        final List<ProductId> invalidProductIds = new ArrayList<>();
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
}
