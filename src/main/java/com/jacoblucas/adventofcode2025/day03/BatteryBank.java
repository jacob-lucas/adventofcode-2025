package com.jacoblucas.adventofcode2025.day03;

import com.google.common.collect.ImmutableList;

import java.util.*;

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
        Battery left = null;
        Battery right = null;
        for (int i = 0; i < bank.length - 1; i++) {
            Battery a = bank[i];
            for (int j = i + 1; j < bank.length; j++) {
                Battery b = bank[j];
                if (left == null && right == null) {
                    left = a;
                    right = b;
                } else {
                    int currentMax = getJoltage(left, right);
                    int candidateMax = getJoltage(a, b);
                    if (candidateMax > currentMax) {
                        left = a;
                        right = b;
                    }
                }
            }
        }
        return ImmutableList.of(left, right);
    }

    public static int getJoltage(Battery... batteries) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(batteries)
                .forEach(b -> sb.append(b.getJoltage()));
        return Integer.parseInt(sb.toString());
    }
}
