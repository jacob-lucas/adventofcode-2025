package com.jacoblucas.adventofcode2025.day03;

import com.jacoblucas.adventofcode2025.Day;
import com.jacoblucas.adventofcode2025.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day03 extends Day {
    private final List<BatteryBank> banks;

    public Day03(List<BatteryBank> banks) {
        this.banks = banks;
    }

    public static void main(String[] args) throws IOException {
        final List<String> bankStrs = InputReader.read("day03-input.txt");
        final List<BatteryBank> banks = bankStrs.stream()
                .map(BatteryBank::of)
                .toList();

        Day03 day03 = new Day03(banks);
        day03.executeWithTimer(day03::part1);
        day03.executeWithTimer(day03::part2);
    }

    @Override
    public void part1() {
        int totalOutputJoltage = banks.stream()
                .map(BatteryBank::getMaxJoltage)
                .mapToInt(bank -> BatteryBank.getJoltage(bank.get(0), bank.get(1)))
                .sum();
        System.out.println(totalOutputJoltage);
    }

    @Override
    public void part2() {

    }
}
