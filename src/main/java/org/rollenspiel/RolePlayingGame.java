package org.rollenspiel;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the role-playing game.
 */
public class RolePlayingGame {
    
    public static void main(String[] args) {
        // Create weapons
        Sword shortSword = new Sword(0);
        Sword longSword = new Sword(2);
        BowAndArrow bow = new BowAndArrow();
        BestialFighting bestialFighting = new BestialFighting();
        // MagicWand is automatically created in the Queen class
        
        // Create player characters
        System.out.println("Creating player characters...");
        
        // Create a regular PC
        PC regularPC = new PC("Regular Player");
        regularPC.addWeapon(shortSword);
        regularPC.addWeapon(bow);
        regularPC.changeWeapon(shortSword);
        
        // Create a fighter
        Fighter fighter = new Fighter("Strong Fighter");
        fighter.addWeapon(longSword);
        fighter.addWeapon(bestialFighting);
        fighter.changeWeapon(longSword);
        
        // Create a knight
        Knight knight = new Knight("Noble Knight");
        knight.addWeapon(longSword);
        knight.addWeapon(shortSword);
        knight.changeWeapon(longSword);
        
        // Create a king
        King king = new King("Royal King");
        king.addWeapon(longSword);
        king.addWeapon(bow);
        king.changeWeapon(longSword);
        
        // Create a queen with magic talent
        Queen queen = new Queen("Magical Queen", 2.5);
        queen.addWeapon(shortSword);
        
        // Create monsters
        System.out.println("\nCreating monsters...");
        Monster goblin = new Monster("Goblin");
        Monster troll = new Monster("Troll");
        Monster dragon = new Monster("Dragon");
        
        // Add all characters to lists
        List<PC> players = new ArrayList<>();
        players.add(regularPC);
        players.add(fighter);
        players.add(knight);
        players.add(king);
        players.add(queen);
        
        List<Character> enemies = new ArrayList<>();
        enemies.add(goblin);
        enemies.add(troll);
        enemies.add(dragon);
        
        // Display initial status
        System.out.println("\n----- INITIAL STATUS -----");
        System.out.println("Players:");
        for (PC player : players) {
            System.out.println(player);
        }
        
        System.out.println("\nEnemies:");
        for (Character enemy : enemies) {
            System.out.println(enemy);
        }
        
        // Create combat round
        CombatRound combatRound = new CombatRound();
        
        // Execute first combat round
        combatRound.executeCombatRound(players, enemies);
        
        // Change weapons for some characters
        System.out.println("\n----- CHANGING WEAPONS -----");
        regularPC.changeWeapon(bow);
        fighter.changeWeapon(bestialFighting);
        
        // Execute second combat round
        combatRound.executeCombatRound(players, enemies);
        
        // Fight to the death between two characters
        System.out.println("\n===== DUEL TO THE DEATH =====");
        Knight challenger = new Knight("Challenger Knight");
        challenger.addWeapon(longSword);
        challenger.changeWeapon(longSword);
        
        Monster boss = new Monster("Boss Monster");
        
        System.out.println("\n" + challenger + " vs " + boss);
        
        int roundCount = 1;
        while (challenger.isAlive() && boss.isAlive()) {
            System.out.println("\n----- DUEL ROUND " + roundCount + " -----");
            
            // Challenger attacks boss
            System.out.println("\n" + challenger.getName() + " attacks " + boss.getName());
            int attackValue = challenger.attack();
            int defenseValue = boss.defend();
            
            if (attackValue > defenseValue) {
                int damage = attackValue - defenseValue;
                boss.takeDamage(damage);
                System.out.println(boss.getName() + " takes " + damage + " damage! HP remaining: " + boss.getHealthPoints());
            } else {
                System.out.println(boss.getName() + " successfully defends the attack!");
            }
            
            // If boss is still alive, boss attacks challenger
            if (boss.isAlive()) {
                System.out.println("\n" + boss.getName() + " attacks " + challenger.getName());
                attackValue = boss.attack();
                defenseValue = challenger.defend();
                
                if (attackValue > defenseValue) {
                    int damage = attackValue - defenseValue;
                    challenger.takeDamage(damage);
                    System.out.println(challenger.getName() + " takes " + damage + " damage! HP remaining: " + challenger.getHealthPoints());
                } else {
                    System.out.println(challenger.getName() + " successfully defends the attack!");
                }
            }
            
            roundCount++;
        }
        
        // Announce the winner
        System.out.println("\n----- DUEL RESULT -----");
        if (challenger.isAlive()) {
            System.out.println(challenger.getName() + " wins the duel!");
        } else {
            System.out.println(boss.getName() + " wins the duel!");
        }
        
        System.out.println("\n===== GAME OVER =====");
    }
}
