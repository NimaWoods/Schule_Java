package org.ducksim.behavior.fly;

public class WingFlapping implements FlyBehavior {
    private final int frequencyPerMin;
    private final int amplitude;

    public WingFlapping() {
        this(120, 5);
    }

    public WingFlapping(int frequencyPerMin, int amplitude) {
        this.frequencyPerMin = Math.max(0, frequencyPerMin);
        this.amplitude = Math.max(0, amplitude);
    }

    @Override
    public void fly() {
        System.out.println("Wing flapping: " + frequencyPerMin + " fpm, amplitude " + amplitude);
    }
}
