package org.rollenspiel;

/**
 * Knight character class.
 * Knights are fighters who can attack twice and use the higher value.
 */
public class Knight extends Fighter {
    
    /**
     * Create a new knight with the given name.
     * @param name The name of the knight
     */
    public Knight(String name) {
        super(name);
    }
    
    @Override
    public int attack() {
        // Knight attacks twice and uses the higher value
        int firstAttack = super.attack();
        int secondAttack = super.attack();
        
        int higherAttack = Math.max(firstAttack, secondAttack);
        System.out.println(getName() + " attacks twice: " + firstAttack + " and " + secondAttack + 
                           " (using " + higherAttack + ")");
        
        return higherAttack;
    }
}
