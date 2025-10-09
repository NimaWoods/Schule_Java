package org.rollenspiel;

import java.util.Random;

/**
 * Bestial Fighting weapon strategy.
 * Attack: 1-2
 * Defense: 1-2
 */
public class BestialFighting implements WeaponStrategy {
    private final Random random = new Random();
    
    @Override
    public int attack() {
        // Attack value between 1 and 2
        return random.nextInt(2) + 1; // 1-2
    }
    
    @Override
    public int defend() {
        // Defense value between 1 and 2
        return random.nextInt(2) + 1; // 1-2
    }
    
    @Override
    public String toString() {
        return "Bestial Fighting";
    }
}
