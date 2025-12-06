package com.jacoblucas.adventofcode2025.day06;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProblemTest {
    @Test
    public void testAdd() {
        Problem problem = new Problem();
        problem.addArg(328);
        problem.addArg(64);
        problem.addArg(98);
        problem.setOperator("+");
        assertThat(problem.solve(), is(490));
    }

    @Test
    public void testMultiply() {
        Problem problem = new Problem();
        problem.addArg(123);
        problem.addArg(45);
        problem.addArg(6);
        problem.setOperator("*");
        assertThat(problem.solve(), is(33210));
    }
}
