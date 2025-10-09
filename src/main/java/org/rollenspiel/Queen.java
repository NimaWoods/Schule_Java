package org.rollenspiel;

/**
 * Queen character class.
 * Queens have magical talent and can use a magic wand.
 */
public class Queen extends PC {
    private final double magicTalent;
    
    /**
     * Create a new queen with the given name and magic talent.
     * @param name The name of the queen
     * @param magicTalent The magic talent (between 1.5 and 3.0)
     */
    public Queen(String name, double magicTalent) {
        super(name);
        // Ensure magic talent is between 1.5 and 3.0
        this.magicTalent = Math.max(1.5, Math.min(3.0, magicTalent));
        
        // Queens start with a magic wand
        MagicWand wand = new MagicWand();
        addWeapon(wand);
        setWeaponStrategy(wand);
    }
    
    /**
     * Get the queen's magic talent.
     * @return The magic talent
     */
    public double getMagicTalent() {
        return magicTalent;
    }
    
    @Override
    public int attack() {
        if (weaponStrategy instanceof MagicWand) {
            // Use magic wand with talent
            MagicWand wand = (MagicWand) weaponStrategy;
            return wand.attack(magicTalent);
        } else {
            // Use normal weapon
            return super.attack();
        }
    }
    
    @Override
    public int defend() {
        if (weaponStrategy instanceof MagicWand) {
            // Use magic wand with talent
            MagicWand wand = (MagicWand) weaponStrategy;
            return wand.defend(magicTalent);
        } else {
            // Use normal weapon
            return super.defend();
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Magic Talent: " + magicTalent + ")";
    }
}
