package org.rollenspiel.weapon;

import java.util.Random;

import org.rollenspiel.weapon.interfaces.WeaponStrategy;

public class BowAndArrow implements WeaponStrategy {
    private final Random random = new Random();
    
    @Override
    public int attack() {
		return random.nextInt(2) + 4;
	}
    
    @Override
    public int defend() {
		return 0;
    }
    
    @Override
    public String toString() {
        return "Bow and Arrow";
    }
}
