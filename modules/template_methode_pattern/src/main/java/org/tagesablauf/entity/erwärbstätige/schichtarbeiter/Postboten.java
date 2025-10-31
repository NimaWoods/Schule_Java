package org.tagesablauf.entity.erwärbstätige.schichtarbeiter;

import org.tagesablauf.entity.erwärbstätige.Schichtarbeiter;

public class Postboten extends Schichtarbeiter {

	@Override
	protected void arbeiten() {
		System.out.println("Arbeiten: Fahrrad Post verteilen");
	}
}
