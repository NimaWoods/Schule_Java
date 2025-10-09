package org.rollenspiel;

import java.util.Random;

/**
 * Magic Wand weapon strategy.
 * Attack: 2-5 (multiplied by magic talent)
 * Defense: 2-5 (multiplied by magic talent)
 * Only usable with magic talent > 0
 */
public class MagicWand implements WeaponStrategy {
    private final Random random = new Random();
    
    @Override
    public int attack() {
        // This method should not be called directly
        // Use attack(double talent) instead
        return 0;
    }
    
    /**
     * Calculate the attack value of the magic wand with the given talent.
     * @param talent The magic talent of the character (1.5-3.0)
     * @return The attack value
     */
    public int attack(double talent) {
        if (talent <= 0) {
            return 0; // Cannot use magic wand without talent
        }
        
        // Base attack is 2-5
        int baseAttack = random.nextInt(4) + 2; // 2-5
        
        // Apply talent multiplier
        return (int) Math.round(baseAttack * talent);
    }
    
    @Override
    public int defend() {
        // This method should not be called directly
        // Use defend(double talent) instead
        return 0;
    }
    
    /**
     * Calculate the defense value of the magic wand with the given talent.
     * @param talent The magic talent of the character (1.5-3.0)
     * @return The defense value
     */
    public int defend(double talent) {
        if (talent <= 0) {
            return 0; // Cannot use magic wand without talent
        }
        
        // Base defense is 2-5
        int baseDefense = random.nextInt(4) + 2; // 2-5
        
        // Apply talent multiplier
        return (int) Math.round(baseDefense * talent);
    }
    
    @Override
    public String toString() {
        return "Magic Wand";
    }
}
