package org.template_methode_pattern.tagesablauf.entity.erwärbstätige.schichtarbeiter;

import org.template_methode_pattern.tagesablauf.entity.erwärbstätige.Schichtarbeiter;

public class Waldarbeiter extends Schichtarbeiter {

	@Override
	protected void arbeiten() {
		System.out.println("Arbeiten: Holz hacken.");
	}
}
