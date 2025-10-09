package org.rollenspiel.entity;

import java.util.ArrayList;
import java.util.List;

import org.rollenspiel.weapon.interfaces.WeaponStrategy;

public class PC extends Character {
    private final List<WeaponStrategy> inventory;
    
    public PC(String name) {
        super(name);
        this.inventory = new ArrayList<>();
		this.inventory.add(weaponStrategy);
    }
    
    public void addWeapon(WeaponStrategy weapon) {
        if (weapon != null && !inventory.contains(weapon)) {
            inventory.add(weapon);
        }
    }
    
    public void changeWeapon(WeaponStrategy weapon) {
        if (weapon != null && inventory.contains(weapon)) {
            setWeaponStrategy(weapon);
            System.out.println(getName() + " changes weapon to " + weapon);
        } else {
            System.out.println(getName() + " doesn't have that weapon in inventory!");
        }
    }
    
    public List<WeaponStrategy> getInventory() {
        return new ArrayList<>(inventory);
    }
    
    public void showInventory() {
        System.out.println(getName() + "'s inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }
}
