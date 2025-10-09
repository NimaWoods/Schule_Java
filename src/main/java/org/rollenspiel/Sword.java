package org.rollenspiel;

import java.util.Random;

/**
 * Sword weapon strategy.
 * Attack: 3-5 + (0-2) based on sword length
 * Defense: 1
 */
public class Sword implements WeaponStrategy {
    private final int length; // 0 = short sword, 2 = long sword
    private final Random random = new Random();
    
    /**
     * Create a new sword with specified length.
     * @param length The length of the sword (0 = short sword, 2 = long sword)
     */
    public Sword(int length) {
        // Ensure length is between 0 and 2
        this.length = Math.max(0, Math.min(2, length));
    }
    
    @Override
    public int attack() {
        // Base attack is 3-5
        int baseAttack = random.nextInt(3) + 3; // 3-5
        // Add bonus based on sword length
        return baseAttack + length;
    }
    
    @Override
    public int defend() {
        // Fixed defense value of 1
        return 1;
    }
    
    @Override
    public String toString() {
        String swordType = length == 0 ? "Short Sword" : (length == 2 ? "Long Sword" : "Medium Sword");
        return swordType;
    }
}
