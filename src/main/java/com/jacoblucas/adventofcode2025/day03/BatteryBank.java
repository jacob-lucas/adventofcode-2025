package com.jacoblucas.adventofcode2025.day03;

import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.stream.Stream;

public class BatteryBank {
    private final Battery[] bank;

    public BatteryBank(final List<Battery> batteries) {
        bank = new Battery[batteries.size()];
        for (int i = 0; i < bank.length; i++) {
            bank[i] = batteries.get(i);
        }
    }

    public static BatteryBank of(final String batteryBankStr) {
        final List<Battery> batteries = new ArrayList<>();
        char[] chars = batteryBankStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            batteries.add(new Battery(i, chars[i] - '0', false));
        }
        return new BatteryBank(batteries);
    }

    public Battery get(int index) {
        return bank[index];
    }

    public List<Battery> getMaxJoltage() {
        return getMaxJoltageHelper(Arrays.asList(bank), 2);
    }

    public List<Battery> getMaxJoltage(int batteriesLeft) {
        return getMaxJoltageHelper(Arrays.asList(bank), batteriesLeft);
    }

    private static List<Battery> getMaxJoltageHelper(List<Battery> bank, int batteriesLeft) {
        if (batteriesLeft == 0) {
            return ImmutableList.of();
        }

        Battery maxBattery = null;
        int maxValue = 0;
        int maxIndex = 0;
        for (int i = 0; i < bank.size(); i++) {
            if (bank.get(i).getJoltage() > maxValue) {
                maxBattery = bank.get(i);
                maxValue = maxBattery.getJoltage();
                maxIndex = i;
            }
        }

        List<Battery> tail = bank.subList(maxIndex, bank.size());
        if (tail.size() == batteriesLeft) {
            return tail;
        } else if (tail.size() < batteriesLeft) {
            return Stream.concat(
                    getMaxJoltageHelper(bank.subList(0, maxIndex), batteriesLeft - tail.size()).stream(),
                    tail.stream())
                    .toList();
        } else {
            return Stream.concat(
                    Stream.of(maxBattery),
                    getMaxJoltageHelper(bank.subList(maxIndex + 1, bank.size()), batteriesLeft - 1).stream())
                    .toList();
        }
    }

    public static long getJoltage(List<Battery> batteries) {
        return getJoltage(batteries.toArray(new Battery[0]));
    }

    public static long getJoltage(Battery... batteries) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(batteries)
                .forEach(b -> sb.append(b.getJoltage()));
        return Long.parseLong(sb.toString());
    }
}
