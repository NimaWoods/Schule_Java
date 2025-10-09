package org.rollenspiel;

/**
 * Monster character class.
 * Monsters always use close combat.
 */
public class Monster extends Character {
    
    /**
     * Create a new monster with the given name.
     * @param name The name of the monster
     */
    public Monster(String name) {
        super(name);
        // Monsters always use close combat
        setWeaponStrategy(new CloseCombat());
    }
}
