package org.rollenspiel;

import java.util.List;

/**
 * Combat round logic for the role-playing game.
 */
public class CombatRound {
    
    /**
     * Execute a combat round between players and enemies.
     * @param players The list of player characters
     * @param enemies The list of enemy characters
     */
    public void executeCombatRound(List<PC> players, List<Character> enemies) {
        System.out.println("\n===== COMBAT ROUND BEGINS =====");
        
        // Players attack enemies
        System.out.println("\n----- PLAYERS ATTACK -----");
        for (PC player : players) {
            if (player.isAlive()) {
                // Find a living enemy to attack
                Character target = findLivingTarget(enemies);
                if (target != null) {
                    executeAttack(player, target);
                } else {
                    System.out.println("All enemies are defeated!");
                    break;
                }
            }
        }
        
        // Enemies attack players
        System.out.println("\n----- ENEMIES ATTACK -----");
        for (Character enemy : enemies) {
            if (enemy.isAlive()) {
                // Find a living player to attack
                PC target = findLivingPlayerTarget(players);
                if (target != null) {
                    executeAttack(enemy, target);
                } else {
                    System.out.println("All players are defeated!");
                    break;
                }
            }
        }
        
        // Option to change weapons
        System.out.println("\n----- WEAPON CHANGE PHASE -----");
        for (PC player : players) {
            if (player.isAlive()) {
                offerWeaponChange(player);
            }
        }
        
        System.out.println("\n===== COMBAT ROUND ENDS =====");
        
        // Display status of all characters
        System.out.println("\n----- STATUS AFTER COMBAT -----");
        System.out.println("Players:");
        for (PC player : players) {
            System.out.println(player);
        }
        
        System.out.println("\nEnemies:");
        for (Character enemy : enemies) {
            System.out.println(enemy);
        }
    }
    
    /**
     * Execute an attack between an attacker and a defender.
     * @param attacker The attacking character
     * @param defender The defending character
     */
    private void executeAttack(Character attacker, Character defender) {
        System.out.println("\n" + attacker.getName() + " attacks " + defender.getName());
        
        int attackValue = attacker.attack();
        System.out.println(attacker.getName() + " attack value: " + attackValue);
        
        int defenseValue = defender.defend();
        System.out.println(defender.getName() + " defense value: " + defenseValue);
        
        if (attackValue > defenseValue) {
            int damage = attackValue - defenseValue;
            defender.takeDamage(damage);
            System.out.println(defender.getName() + " takes " + damage + " damage! HP remaining: " + defender.getHealthPoints());
            
            if (!defender.isAlive()) {
                System.out.println(defender.getName() + " has been defeated!");
            }
        } else {
            System.out.println(defender.getName() + " successfully defends the attack!");
        }
    }
    
    /**
     * Find a living target among the given characters.
     * @param targets The list of potential targets
     * @return A living target, or null if none are alive
     */
    private Character findLivingTarget(List<Character> targets) {
        for (Character target : targets) {
            if (target.isAlive()) {
                return target;
            }
        }
        return null;
    }
    
    /**
     * Find a living player target among the given players.
     * @param targets The list of potential player targets
     * @return A living player target, or null if none are alive
     */
    private PC findLivingPlayerTarget(List<PC> targets) {
        for (PC target : targets) {
            if (target.isAlive()) {
                return target;
            }
        }
        return null;
    }
    
    /**
     * Offer the player the option to change weapons.
     * @param player The player character
     */
    private void offerWeaponChange(PC player) {
        System.out.println("\n" + player.getName() + ", do you want to change your weapon? (y/n)");
        // For automated testing, we'll just print the inventory and not actually wait for input
        player.showInventory();
        System.out.println("Current weapon: " + player.weaponStrategy);
        
        // In a real game, you would uncomment this code to allow user input
        /*
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("y") || response.equals("yes")) {
            player.showInventory();
            System.out.println("Enter the number of the weapon you want to use:");
            try {
                int weaponIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (weaponIndex >= 0 && weaponIndex < player.getInventory().size()) {
                    player.changeWeapon(player.getInventory().get(weaponIndex));
                } else {
                    System.out.println("Invalid weapon number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        */
    }
}
