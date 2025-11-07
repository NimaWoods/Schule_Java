package org.template_methode_pattern.tagesablauf.entity.erwärbstätige;

import org.template_methode_pattern.tagesablauf.entity.Erwerbstätige;

public class Büroarbeiter extends Erwerbstätige {

	@Override
	protected void frühstück() {
		System.out.println("Essen: Gesundes Müsli");
	}

	@Override
	protected void arbeiten() {
		System.out.println("Arbeiten: Schreibtisch");
	}
}
