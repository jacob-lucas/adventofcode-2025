package com.jacoblucas.adventofcode2025.utils;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputReaderTest {
    private static final String TEST_PATH = "src/test/resources/";

    @Test
    public void failureOnFileNotFound() {
        assertThrows(IOException.class, () ->
                InputReader.readFile(TEST_PATH, "does_not_exist.txt"));
    }

    @Test
    public void returnsPopulatedStreamOnReadableFile() throws IOException {
        final List<String> lines = InputReader.readFile(TEST_PATH,"test-input.txt");
        assertThat(lines, is(ImmutableList.of("1","2","3")));
    }

    @Test
    public void readUsesDefaultPath() {
        assertThrows(IOException.class, () ->
                InputReader.read("test-input.txt"));
    }

    @Test
    public void readGroupsUsesDefaultPath() {
        assertThrows(IOException.class, () ->
                InputReader.readGroups("test-input.txt"));
    }

    @Test
    public void testReadGroups() throws IOException {
        final List<List<String>> groups = InputReader.readGroups(TEST_PATH, "grouped-input.txt");

        assertThat(groups, is(ImmutableList.of(
                ImmutableList.of("1", "2", "3"),
                ImmutableList.of("4", "5"),
                ImmutableList.of("6"),
                ImmutableList.of("7", "8", "9", "0"))));
    }
}
