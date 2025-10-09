package org.rollenspiel;

import java.util.ArrayList;
import java.util.List;

import org.rollenspiel.entity.Character;
import org.rollenspiel.entity.Fighter;
import org.rollenspiel.entity.King;
import org.rollenspiel.entity.Knight;
import org.rollenspiel.entity.Monster;
import org.rollenspiel.entity.PC;
import org.rollenspiel.entity.Queen;
import org.rollenspiel.weapon.BestialFighting;
import org.rollenspiel.weapon.BowAndArrow;
import org.rollenspiel.weapon.Sword;

public class RolePlayingGame {
    
    public static void main(String[] args) {
		Sword shortSword = new Sword(0);
        Sword longSword = new Sword(2);
        BowAndArrow bow = new BowAndArrow();
        BestialFighting bestialFighting = new BestialFighting();

		System.out.println("Creating player characters...");

		PC regularPC = new PC("Regular Player");
        regularPC.addWeapon(shortSword);
        regularPC.addWeapon(bow);
        regularPC.changeWeapon(shortSword);

		Fighter fighter = new Fighter("Strong Fighter");
        fighter.addWeapon(longSword);
        fighter.addWeapon(bestialFighting);
        fighter.changeWeapon(longSword);

		Knight knight = new Knight("Noble Knight");
        knight.addWeapon(longSword);
        knight.addWeapon(shortSword);
        knight.changeWeapon(longSword);

		King king = new King("Royal King");
        king.addWeapon(longSword);
        king.addWeapon(bow);
        king.changeWeapon(longSword);

		Queen queen = new Queen("Magical Queen", 2.5);
        queen.addWeapon(shortSword);

		System.out.println("\nCreating monsters...");
        Monster goblin = new Monster("Goblin");
        Monster troll = new Monster("Troll");
        Monster dragon = new Monster("Dragon");

		List<PC> players = new ArrayList<>();
        players.add(regularPC);
        players.add(fighter);
        players.add(knight);
        players.add(king);
        players.add(queen);
        
        List<org.rollenspiel.entity.Character> enemies = new ArrayList<>();
        enemies.add(goblin);
        enemies.add(troll);
        enemies.add(dragon);

		System.out.println("\n----- INITIAL STATUS -----");
        System.out.println("Players:");
        for (PC player : players) {
            System.out.println(player);
        }
        
        System.out.println("\nEnemies:");
        for (Character enemy : enemies) {
            System.out.println(enemy);
        }

		CombatRound combatRound = new CombatRound();

		combatRound.executeCombatRound(players, enemies);

		System.out.println("\n----- CHANGING WEAPONS -----");
        regularPC.changeWeapon(bow);
        fighter.changeWeapon(bestialFighting);

		combatRound.executeCombatRound(players, enemies);

		System.out.println("\n===== DUEL TO THE DEATH =====");
        Knight challenger = new Knight("Challenger Knight");
        challenger.addWeapon(longSword);
        challenger.changeWeapon(longSword);
        
        Monster boss = new Monster("Boss Monster");
        
        System.out.println("\n" + challenger + " vs " + boss);
        
        int roundCount = 1;
        while (challenger.isAlive() && boss.isAlive()) {
            System.out.println("\n----- DUEL ROUND " + roundCount + " -----");

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

		System.out.println("\n----- DUEL RESULT -----");
        if (challenger.isAlive()) {
            System.out.println(challenger.getName() + " wins the duel!");
        } else {
            System.out.println(boss.getName() + " wins the duel!");
        }
        
        System.out.println("\n===== GAME OVER =====");
    }
}
