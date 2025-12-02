package com.jacoblucas.adventofcode2025.day02;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductIdRangeTest {
    @Test
    public void testParse() {
        assertThat(ProductIdRange.parse("11-22"), is(new ProductIdRange(11, 22)));
    }

    @Test
    public void testToList() {
        final ProductIdRange range = ProductIdRange.parse("11-22");
        final List<ProductId> productIds = range.stream().toList();
        assertThat(productIds, is(ImmutableList.of(
                new ProductId(11),
                new ProductId(12),
                new ProductId(13),
                new ProductId(14),
                new ProductId(15),
                new ProductId(16),
                new ProductId(17),
                new ProductId(18),
                new ProductId(19),
                new ProductId(20),
                new ProductId(21),
                new ProductId(22))));
    }
}
