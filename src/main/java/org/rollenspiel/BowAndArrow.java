package org.rollenspiel;

import java.util.Random;

/**
 * Bow and Arrow weapon strategy.
 * Attack: 4-5
 * Defense: 0
 */
public class BowAndArrow implements WeaponStrategy {
    private final Random random = new Random();
    
    @Override
    public int attack() {
        // Attack value between 4 and 5
        return random.nextInt(2) + 4; // 4-5
    }
    
    @Override
    public int defend() {
        // Fixed defense value of 0
        return 0;
    }
    
    @Override
    public String toString() {
        return "Bow and Arrow";
    }
}
