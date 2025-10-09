package org.ducksim.behavior.fly;

public class NotFlying implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Not flying.");
    }
}
