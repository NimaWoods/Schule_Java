package org.tagesablauf.entity.erwärbstätige.schichtarbeiter;

import org.tagesablauf.entity.erwärbstätige.Schichtarbeiter;

public class Waldarbeiter extends Schichtarbeiter {

	@Override
	protected void arbeiten() {
		System.out.println("Arbeiten: Holz hacken.");
	}
}
