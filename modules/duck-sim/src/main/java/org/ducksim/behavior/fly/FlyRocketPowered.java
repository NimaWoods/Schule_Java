package org.ducksim.behavior.fly;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Rocket powered flying! Whooosh!");
    }
}
