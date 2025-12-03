package com.jacoblucas.adventofcode2025.day03;

public final class Battery {
    private final int id;
    private final int joltage;
    private boolean status;

    public Battery(int id, int joltage, boolean status) {
        this.id = id;
        this.joltage = joltage;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getJoltage() {
        return joltage;
    }

    public boolean status() {
        return status;
    }

    public void toggle() {
        status = !status;
    }

    public void on() {
        status = true;
    }

    public void off() {
        status = false;
    }

    @Override
    public String toString() {
        return "Battery[ID=" + id + ", Joltage=" + joltage + ", Status=" + status + "]";
    }
}
