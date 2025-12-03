package com.jacoblucas.adventofcode2025;

import java.time.Duration;

public abstract class Day {
    public void executeWithTimer(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();

        Duration duration = Duration.ofMillis(end - start);
        System.out.printf("Execution time: %s\n", duration);
    }

    public abstract void part1();

    public abstract void part2();
}
