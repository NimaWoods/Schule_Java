package org.rollenspiel.entity;

import org.rollenspiel.weapon.MagicWand;

public class Queen extends PC {
    private final double magicTalent;
    
    public Queen(String name, double magicTalent) {
        super(name);
		this.magicTalent = Math.max(1.5, Math.min(3.0, magicTalent));

		MagicWand wand = new MagicWand();
        addWeapon(wand);
        setWeaponStrategy(wand);
    }
    
    public double getMagicTalent() {
        return magicTalent;
    }
    
    @Override
    public int attack() {
        if (weaponStrategy instanceof MagicWand) {
			MagicWand wand = (MagicWand) weaponStrategy;
            return wand.attack(magicTalent);
        } else {
			return super.attack();
        }
    }
    
    @Override
    public int defend() {
        if (weaponStrategy instanceof MagicWand) {
			MagicWand wand = (MagicWand) weaponStrategy;
            return wand.defend(magicTalent);
        } else {
			return super.defend();
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Magic Talent: " + magicTalent + ")";
    }
}
