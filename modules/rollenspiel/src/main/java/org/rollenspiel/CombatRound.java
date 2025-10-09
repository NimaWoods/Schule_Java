package org.rollenspiel;

import java.util.List;

import org.rollenspiel.entity.Character;
import org.rollenspiel.entity.PC;

public class CombatRound {
    
    public void executeCombatRound(List<PC> players, List<org.rollenspiel.entity.Character> enemies) {
        System.out.println("\n===== COMBAT ROUND BEGINS =====");

		System.out.println("\n----- PLAYERS ATTACK -----");
        for (PC player : players) {
            if (player.isAlive()) {
				org.rollenspiel.entity.Character target = findLivingTarget(enemies);
                if (target != null) {
                    executeAttack(player, target);
                } else {
                    System.out.println("All enemies are defeated!");
                    break;
                }
            }
        }

		System.out.println("\n----- ENEMIES ATTACK -----");
        for (org.rollenspiel.entity.Character enemy : enemies) {
            if (enemy.isAlive()) {
				PC target = findLivingPlayerTarget(players);
                if (target != null) {
                    executeAttack(enemy, target);
                } else {
                    System.out.println("All players are defeated!");
                    break;
                }
            }
        }

		System.out.println("\n----- WEAPON CHANGE PHASE -----");
        for (PC player : players) {
            if (player.isAlive()) {
                offerWeaponChange(player);
            }
        }
        
        System.out.println("\n===== COMBAT ROUND ENDS =====");

		System.out.println("\n----- STATUS AFTER COMBAT -----");
        System.out.println("Players:");
        for (PC player : players) {
            System.out.println(player);
        }
        
        System.out.println("\nEnemies:");
        for (org.rollenspiel.entity.Character enemy : enemies) {
            System.out.println(enemy);
        }
    }
    
    private void executeAttack(org.rollenspiel.entity.Character attacker, org.rollenspiel.entity.Character defender) {
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
    
    private org.rollenspiel.entity.Character findLivingTarget(List<org.rollenspiel.entity.Character> targets) {
        for (Character target : targets) {
            if (target.isAlive()) {
                return target;
            }
        }
        return null;
    }
    
    private PC findLivingPlayerTarget(List<PC> targets) {
        for (PC target : targets) {
            if (target.isAlive()) {
                return target;
            }
        }
        return null;
    }
    
    private void offerWeaponChange(PC player) {
        System.out.println("\n" + player.getName() + ", do you want to change your weapon? (y/n)");
		player.showInventory();
        System.out.println("Current weapon: " + player.weaponStrategy);

	}
}
