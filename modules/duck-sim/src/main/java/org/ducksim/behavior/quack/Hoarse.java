package org.ducksim.behavior.quack;

public class Hoarse implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Hrrrh... (hoarse quack)");
    }
}
