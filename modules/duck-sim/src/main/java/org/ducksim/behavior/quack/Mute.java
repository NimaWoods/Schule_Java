package org.ducksim.behavior.quack;

public class Mute implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("...");
    }
}
