package org.ducksim.behavior.fly;

public class Gliding implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Gliding smoothly over the water...");
    }
}
