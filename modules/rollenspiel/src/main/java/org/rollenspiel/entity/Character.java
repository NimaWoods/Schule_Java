package org.rollenspiel.entity;

import org.rollenspiel.CloseCombat;
import org.rollenspiel.weapon.interfaces.WeaponStrategy;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {
    @Getter
	private final String name;
    @Getter
	private int healthPoints;
    private static final int MAX_HEALTH = 20;
    @Setter
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

	@Override
    public String toString() {
        return name + " (HP: " + healthPoints + ", Weapon: " + weaponStrategy + ")";
    }
}
