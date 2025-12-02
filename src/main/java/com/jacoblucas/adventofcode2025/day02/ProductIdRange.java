package com.jacoblucas.adventofcode2025.day02;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public record ProductIdRange(long lower, long upper) {
    public static ProductIdRange parse(String input) {
        final String[] parts = input.split("-");
        return new ProductIdRange(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
    }

    public Stream<ProductId> stream() {
        return LongStream.rangeClosed(lower, upper).mapToObj(ProductId::new);
    }
}
