package org.rollenspiel.entity;

public class King extends Fighter {
    
    public King(String name) {
        super(name);
    }
    
    @Override
    public int defend() {
		int firstDefense = super.defend();
        int secondDefense = super.defend();
        
        int higherDefense = Math.max(firstDefense, secondDefense);
        System.out.println(getName() + " defends twice: " + firstDefense + " and " + secondDefense + 
                           " (using " + higherDefense + ")");
        
        return higherDefense;
    }
}
