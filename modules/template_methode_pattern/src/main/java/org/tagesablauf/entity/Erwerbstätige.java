package org.tagesablauf.entity;

public abstract class Erwerbstätige {

	public final void tagesablauf() {
		aufstehen();
		frühstück();
		zurArbeitFahren();
		arbeiten();
		nachHauseFahren();
		entspannen();
		zuBettGehen();
	}

	protected void aufstehen() {
		System.out.println("Aufstehen.");
	}

	protected void frühstück() {
		System.out.println("Früstück");
	}

	protected void zurArbeitFahren() {
		System.out.println("Zur Arbeit Fahren.");
	}

	protected void arbeiten() {
		System.out.println("Arbeiten.");
	}

	protected void nachHauseFahren() {
		System.out.println("Nach Hause Fahren.");
	}

	protected void entspannen() {
		System.out.println("Entspannen.");
	}

	protected void zuBettGehen() {
		System.out.println("Zu Bett Gehen.");
	}
}
