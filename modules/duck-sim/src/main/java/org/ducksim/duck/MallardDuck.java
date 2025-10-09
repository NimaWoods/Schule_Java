package org.ducksim.duck;

import org.ducksim.behavior.fly.FlyBehavior;
import org.ducksim.behavior.fly.WingFlapping;
import org.ducksim.behavior.quack.QuackBehavior;
import org.ducksim.behavior.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new Quack(), new WingFlapping());
    }

    public MallardDuck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        super(quackBehavior, flyBehavior);
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard duck.");
    }
}
