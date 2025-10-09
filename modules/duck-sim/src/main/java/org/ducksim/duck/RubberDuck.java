package org.ducksim.duck;

import org.ducksim.behavior.fly.FlyBehavior;
import org.ducksim.behavior.fly.NotFlying;
import org.ducksim.behavior.quack.QuackBehavior;
import org.ducksim.behavior.quack.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        super(new Squeak(), new NotFlying());
    }

    // Allow custom behaviors if needed
    public RubberDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }

    @Override
    public void display() {
        System.out.println("I'm a Rubber duck.");
    }
}
