package org.rollenspiel;

/**
 * Base class for all characters in the role-playing game.
 */
public abstract class Character {
    private final String name;
    private int healthPoints;
    private static final int MAX_HEALTH = 20;
    protected WeaponStrategy weaponStrategy;
    
    /**
     * Create a new character with the given name.
     * @param name The name of the character
     */
    public Character(String name) {
        this.name = name;
        this.healthPoints = MAX_HEALTH;
        // Default weapon strategy is close combat
        this.weaponStrategy = new CloseCombat();
    }
    
    /**
     * Calculate the attack value of the character.
     * @return The attack value
     */
    public int attack() {
        return weaponStrategy.attack();
    }
    
    /**
     * Calculate the defense value of the character.
     * @return The defense value
     */
    public int defend() {
        return weaponStrategy.defend();
    }
    
    /**
     * Apply damage to the character.
     * @param damage The amount of damage to take
     */
    public void takeDamage(int damage) {
        if (damage > 0) {
            healthPoints = Math.max(0, healthPoints - damage);
        }
    }
    
    /**
     * Check if the character is still alive.
     * @return true if the character has health points left, false otherwise
     */
    public boolean isAlive() {
        return healthPoints > 0;
    }
    
    /**
     * Get the name of the character.
     * @return The name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the current health points of the character.
     * @return The health points
     */
    public int getHealthPoints() {
        return healthPoints;
    }
    
    /**
     * Set the weapon strategy of the character.
     * @param strategy The new weapon strategy
     */
    public void setWeaponStrategy(WeaponStrategy strategy) {
        this.weaponStrategy = strategy;
    }
    
    @Override
    public String toString() {
        return name + " (HP: " + healthPoints + ", Weapon: " + weaponStrategy + ")";
    }
}
