package org.rollenspiel;

import java.util.Random;

import org.rollenspiel.weapon.interfaces.WeaponStrategy;

public class CloseCombat implements WeaponStrategy {
    private final Random random = new Random();
    
    @Override
    public int attack() {
		return random.nextInt(2) + 1;
	}
    
    @Override
    public int defend() {
		return random.nextInt(2) + 1;
	}
    
    @Override
    public String toString() {
        return "Close Combat";
    }
}
