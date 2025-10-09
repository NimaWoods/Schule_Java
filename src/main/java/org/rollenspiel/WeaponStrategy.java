package org.rollenspiel;

/**
 * Interface for weapon strategies in the role-playing game.
 * Each weapon has its own attack and defense capabilities.
 */
public interface WeaponStrategy {
    /**
     * Calculate the attack value of the weapon.
     * @return The attack value
     */
    int attack();
    
    /**
     * Calculate the defense value of the weapon.
     * @return The defense value
     */
    int defend();
}
