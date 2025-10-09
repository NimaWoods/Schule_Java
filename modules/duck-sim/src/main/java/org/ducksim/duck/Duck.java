package org.ducksim.duck;

import org.ducksim.behavior.fly.FlyBehavior;
import org.ducksim.behavior.quack.QuackBehavior;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    protected Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior) {
        setQuackBehavior(quackBehavior);
        setFlyBehavior(flyBehavior);
    }

    public final void setFlyBehavior(FlyBehavior flyBehavior) {
        if (flyBehavior == null) throw new IllegalArgumentException("flyBehavior must not be null");
        this.flyBehavior = flyBehavior;
    }

    public final void setQuackBehavior(QuackBehavior quackBehavior) {
        if (quackBehavior == null) throw new IllegalArgumentException("quackBehavior must not be null");
        this.quackBehavior = quackBehavior;
    }

    public final void doFly() {
        flyBehavior.fly();
    }

    public final void doQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("Swimming...");
    }

    public abstract void display();
}
