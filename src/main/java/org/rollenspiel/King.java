package org.rollenspiel;

/**
 * King character class.
 * Kings are fighters who can defend twice and use the higher value.
 */
public class King extends Fighter {
    
    /**
     * Create a new king with the given name.
     * @param name The name of the king
     */
    public King(String name) {
        super(name);
    }
    
    @Override
    public int defend() {
        // King defends twice and uses the higher value
        int firstDefense = super.defend();
        int secondDefense = super.defend();
        
        int higherDefense = Math.max(firstDefense, secondDefense);
        System.out.println(getName() + " defends twice: " + firstDefense + " and " + secondDefense + 
                           " (using " + higherDefense + ")");
        
        return higherDefense;
    }
}
