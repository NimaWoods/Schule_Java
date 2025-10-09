package org.rollenspiel;

import java.util.ArrayList;
import java.util.List;

/**
 * Player Character class.
 * PCs have an inventory of weapons and can change their weapon.
 */
public class PC extends Character {
    private final List<WeaponStrategy> inventory;
    
    /**
     * Create a new player character with the given name.
     * @param name The name of the character
     */
    public PC(String name) {
        super(name);
        this.inventory = new ArrayList<>();
        // Add default weapon (close combat) to inventory
        this.inventory.add(weaponStrategy);
    }
    
    /**
     * Add a weapon to the character's inventory.
     * @param weapon The weapon to add
     */
    public void addWeapon(WeaponStrategy weapon) {
        if (weapon != null && !inventory.contains(weapon)) {
            inventory.add(weapon);
        }
    }
    
    /**
     * Change the character's current weapon.
     * @param weapon The weapon to change to
     */
    public void changeWeapon(WeaponStrategy weapon) {
        if (weapon != null && inventory.contains(weapon)) {
            setWeaponStrategy(weapon);
            System.out.println(getName() + " changes weapon to " + weapon);
        } else {
            System.out.println(getName() + " doesn't have that weapon in inventory!");
        }
    }
    
    /**
     * Get the character's weapon inventory.
     * @return The inventory
     */
    public List<WeaponStrategy> getInventory() {
        return new ArrayList<>(inventory);
    }
    
    /**
     * Display the character's weapon inventory.
     */
    public void showInventory() {
        System.out.println(getName() + "'s inventory:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }
}
