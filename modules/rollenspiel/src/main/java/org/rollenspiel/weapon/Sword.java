package org.rollenspiel.weapon;

import java.util.Random;

import org.rollenspiel.weapon.interfaces.WeaponStrategy;

public class Sword implements WeaponStrategy {
    private final int length;
	private final Random random = new Random();
    
    public Sword(int length) {
		this.length = Math.max(0, Math.min(2, length));
    }
    
    @Override
    public int attack() {
		int baseAttack = random.nextInt(3) + 3;
		return baseAttack + length;
    }
    
    @Override
    public int defend() {
		return 1;
    }
    
    @Override
    public String toString() {
        String swordType = length == 0 ? "Short Sword" : (length == 2 ? "Long Sword" : "Medium Sword");
        return swordType;
    }
}
