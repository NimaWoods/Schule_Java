package org.template_methode_pattern.tagesablauf.entity.erwärbstätige;

import org.template_methode_pattern.tagesablauf.entity.Erwerbstätige;

public class Schichtarbeiter extends Erwerbstätige {

	@Override
	protected void frühstück() {
		System.out.println("Frühstück: Großes Frühstück");
	}

	@Override
	protected void entspannen() {
		System.out.println("Entspannen: Fernsehen");
	}
}
