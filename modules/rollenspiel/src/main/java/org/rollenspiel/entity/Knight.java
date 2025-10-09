package org.rollenspiel.entity;

public class Knight extends Fighter {
    
    public Knight(String name) {
        super(name);
    }
    
    @Override
    public int attack() {
		int firstAttack = super.attack();
        int secondAttack = super.attack();
        
        int higherAttack = Math.max(firstAttack, secondAttack);
        System.out.println(getName() + " attacks twice: " + firstAttack + " and " + secondAttack + 
                           " (using " + higherAttack + ")");
        
        return higherAttack;
    }
}
