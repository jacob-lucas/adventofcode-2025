package com.jacoblucas.adventofcode2025.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BatteryBankTest {
    @Test
    public void testGetJoltage() {
        BatteryBank batteryBank  = BatteryBank.of("987654321111111");
        assertThat(BatteryBank.getJoltage(batteryBank.get(0), batteryBank.get(1)), is(98));
    }

    @Test
    public void testGetMaxJoltage1() {
        BatteryBank batteryBank  = BatteryBank.of("987654321111111");
        List<Battery> maxJoltage = batteryBank.getMaxJoltage();
        assertThat(maxJoltage.get(0).getJoltage(), is(9));
        assertThat(maxJoltage.get(1).getJoltage(), is(8));
    }

    @Test
    public void testGetMaxJoltage2() {
        BatteryBank batteryBank  = BatteryBank.of("811111111111119");
        List<Battery> maxJoltage = batteryBank.getMaxJoltage();
        assertThat(maxJoltage.get(0).getJoltage(), is(8));
        assertThat(maxJoltage.get(1).getJoltage(), is(9));
    }

    @Test
    public void testGetMaxJoltage3() {
        BatteryBank batteryBank  = BatteryBank.of("234234234234278");
        List<Battery> maxJoltage = batteryBank.getMaxJoltage();
        assertThat(maxJoltage.get(0).getJoltage(), is(7));
        assertThat(maxJoltage.get(1).getJoltage(), is(8));
    }

    @Test
    public void testGetMaxJoltage4() {
        BatteryBank batteryBank  = BatteryBank.of("818181911112111");
        List<Battery> maxJoltage = batteryBank.getMaxJoltage();
        assertThat(maxJoltage.get(0).getJoltage(), is(9));
        assertThat(maxJoltage.get(1).getJoltage(), is(2));
    }

    @Test
    public void testGetMaxJoltage5() {
        BatteryBank batteryBank  = BatteryBank.of("2353224242223333222212222212122232212325242222323234222233222242242213332433221534222221224132232122");
        List<Battery> maxJoltage = batteryBank.getMaxJoltage();
        assertThat(maxJoltage.get(0).getJoltage(), is(5));
        assertThat(maxJoltage.get(1).getJoltage(), is(5));
    }
}
