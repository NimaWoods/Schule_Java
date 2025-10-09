package org.rollenspiel.entity;

import org.rollenspiel.CloseCombat;
import org.rollenspiel.weapon.interfaces.WeaponStrategy;

public abstract class Character {
    private final String name;
    private int healthPoints;
    private static final int MAX_HEALTH = 20;
    public WeaponStrategy weaponStrategy;
    
    public Character(String name) {
        this.name = name;
        this.healthPoints = MAX_HEALTH;
		this.weaponStrategy = new CloseCombat();
    }
    
    public int attack() {
        return weaponStrategy.attack();
    }
    
    public int defend() {
        return weaponStrategy.defend();
    }
    
    public void takeDamage(int damage) {
        if (damage > 0) {
            healthPoints = Math.max(0, healthPoints - damage);
        }
    }
    
    public boolean isAlive() {
        return healthPoints > 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHealthPoints() {
        return healthPoints;
    }
    
    public void setWeaponStrategy(WeaponStrategy strategy) {
        this.weaponStrategy = strategy;
    }
    
    @Override
    public String toString() {
        return name + " (HP: " + healthPoints + ", Weapon: " + weaponStrategy + ")";
    }
}
