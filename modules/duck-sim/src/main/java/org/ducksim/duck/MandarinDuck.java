package org.ducksim.duck;

import org.ducksim.behavior.fly.FlyBehavior;
import org.ducksim.behavior.quack.QuackBehavior;

public class MandarinDuck extends Duck {
    public MandarinDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }

    @Override
    public void display() {
        System.out.println("I'm a Mandarin duck.");
    }
}
