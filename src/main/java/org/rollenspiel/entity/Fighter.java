package org.rollenspiel.entity;

public class Fighter extends PC {
    private static final int FIGHTER_BONUS = 2;
    
    public Fighter(String name) {
        super(name);
    }
    
    @Override
    public int attack() {
		return super.attack() + FIGHTER_BONUS;
    }
    
    @Override
    public int defend() {
		return super.defend() + FIGHTER_BONUS;
    }
}
