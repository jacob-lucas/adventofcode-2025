package com.jacoblucas.adventofcode2025.day02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ProductIdTest {
    @Test
    public void testValid() {
        assertThat(new ProductId(10).isValid(), is(true));
        assertThat(new ProductId(23).isValid(), is(true));
        assertThat(new ProductId(999).isValid(), is(true));
        assertThat(new ProductId(1011).isValid(), is(true));
        assertThat(new ProductId(1188411885).isValid(), is(true));
        assertThat(new ProductId(22222).isValid(), is(true));
        assertThat(new ProductId(2232).isValid(), is(true));
        assertThat(new ProductId(446447).isValid(), is(true));
        assertThat(new ProductId(38593850).isValid(), is(true));
    }


    @Test
    public void testInvalid() {
        assertThat(new ProductId(11).isValid(), is(false));
        assertThat(new ProductId(22).isValid(), is(false));
        assertThat(new ProductId(99).isValid(), is(false));
        assertThat(new ProductId(1010).isValid(), is(false));
        assertThat(new ProductId(1188511885).isValid(), is(false));
        assertThat(new ProductId(222222).isValid(), is(false));
        assertThat(new ProductId(2222).isValid(), is(false));
        assertThat(new ProductId(446446).isValid(), is(false));
        assertThat(new ProductId(38593859).isValid(), is(false));
    }

    @Test
    public void testValidV2() {
        assertThat(new ProductId(10).isValidV2(), is(true));
        assertThat(new ProductId(23).isValidV2(), is(true));
        assertThat(new ProductId(998).isValidV2(), is(true));
        assertThat(new ProductId(1011).isValidV2(), is(true));
        assertThat(new ProductId(1188411885).isValidV2(), is(true));
        assertThat(new ProductId(2232).isValidV2(), is(true));
        assertThat(new ProductId(446447).isValidV2(), is(true));
        assertThat(new ProductId(38593850).isValidV2(), is(true));
    }

    @Test
    public void testInvalidV2() {
        assertThat(new ProductId(11).isValidV2(), is(false));
        assertThat(new ProductId(22).isValidV2(), is(false));
        assertThat(new ProductId(99).isValidV2(), is(false));
        assertThat(new ProductId(111).isValidV2(), is(false));
        assertThat(new ProductId(999).isValidV2(), is(false));
        assertThat(new ProductId(1010).isValidV2(), is(false));
        assertThat(new ProductId(1188511885).isValidV2(), is(false));
        assertThat(new ProductId(222222).isValidV2(), is(false));
        assertThat(new ProductId(2222).isValidV2(), is(false));
        assertThat(new ProductId(446446).isValidV2(), is(false));
        assertThat(new ProductId(38593859).isValidV2(), is(false));
        assertThat(new ProductId(565656).isValidV2(), is(false));
        assertThat(new ProductId(2121212121).isValidV2(), is(false));
    }
}