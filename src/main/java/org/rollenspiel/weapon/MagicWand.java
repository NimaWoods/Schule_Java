package org.rollenspiel.weapon;

import java.util.Random;

import org.rollenspiel.weapon.interfaces.WeaponStrategy;

public class MagicWand implements WeaponStrategy {
    private final Random random = new Random();
    
    @Override
    public int attack() {
		return 0;
    }
    
    public int attack(double talent) {
        if (talent <= 0) {
            return 0;
		}

		int baseAttack = random.nextInt(4) + 2;

		return (int) Math.round(baseAttack * talent);
    }
    
    @Override
    public int defend() {
		return 0;
    }
    
    public int defend(double talent) {
        if (talent <= 0) {
            return 0;
		}

		int baseDefense = random.nextInt(4) + 2;

		return (int) Math.round(baseDefense * talent);
    }
    
    @Override
    public String toString() {
        return "Magic Wand";
    }
}
