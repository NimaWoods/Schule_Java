package org.rollenspiel;

/**
 * Fighter character class.
 * Fighters get a +2 bonus to both attack and defense.
 */
public class Fighter extends PC {
    private static final int FIGHTER_BONUS = 2;
    
    /**
     * Create a new fighter with the given name.
     * @param name The name of the fighter
     */
    public Fighter(String name) {
        super(name);
    }
    
    @Override
    public int attack() {
        // Fighter gets a bonus of 2 to attack
        return super.attack() + FIGHTER_BONUS;
    }
    
    @Override
    public int defend() {
        // Fighter gets a bonus of 2 to defense
        return super.defend() + FIGHTER_BONUS;
    }
}
