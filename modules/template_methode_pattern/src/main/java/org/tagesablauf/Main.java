package org.tagesablauf;

import org.tagesablauf.entity.erwärbstätige.Büroarbeiter;
import org.tagesablauf.entity.Erwerbstätige;
import org.tagesablauf.entity.erwärbstätige.Manager;
import org.tagesablauf.entity.erwärbstätige.schichtarbeiter.Postboten;
import org.tagesablauf.entity.erwärbstätige.schichtarbeiter.Waldarbeiter;

public class Main {
	public static void main(String[] args) {
		System.out.println("Waldarbeiter");
		Erwerbstätige waldarbeiter = new Waldarbeiter();
		waldarbeiter.tagesablauf();

		System.out.println("\nPostbote");
		Erwerbstätige postbote = new Postboten();
		postbote.tagesablauf();

		System.out.println("\nBüroarbeiter");
		Erwerbstätige büroarbeiter = new Büroarbeiter();
		büroarbeiter.tagesablauf();

		System.out.println("\nManager");
		Erwerbstätige manager = new Manager();
		manager.tagesablauf();
	}
}
