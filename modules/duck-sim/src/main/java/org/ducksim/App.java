package org.ducksim;

import org.ducksim.behavior.fly.*;
import org.ducksim.behavior.quack.*;
import org.ducksim.duck.*;

public class App {
    public static void main(String[] args) {
        System.out.println("-- DuckSim Strategy Pattern Demo --");

        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.doQuack();
        mallard.doFly();

        System.out.println("\n-- Change behaviors at runtime --");
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.setQuackBehavior(new Hoarse());
        mallard.doQuack();
        mallard.doFly();

        System.out.println("\n-- Rubber duck --");
        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.doQuack();
        rubber.doFly();

        System.out.println("\n-- Mandarin duck with custom constructor --");
        Duck mandarin = new MandarinDuck(new Quack(), new Gliding());
        mandarin.display();
        mandarin.doQuack();
        mandarin.doFly();

        System.out.println("\nDemo finished.");
    }
}
