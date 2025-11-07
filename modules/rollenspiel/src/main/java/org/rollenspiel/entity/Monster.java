package org.rollenspiel.entity;

import org.rollenspiel.weapon.CloseCombat;

public class Monster extends Character {
    
    public Monster(String name) {
        super(name);
		setWeaponStrategy(new CloseCombat());
    }
}
