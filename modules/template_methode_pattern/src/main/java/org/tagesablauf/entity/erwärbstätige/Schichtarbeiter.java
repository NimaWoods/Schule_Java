package org.tagesablauf.entity.erwärbstätige;

import org.tagesablauf.entity.Erwerbstätige;

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
