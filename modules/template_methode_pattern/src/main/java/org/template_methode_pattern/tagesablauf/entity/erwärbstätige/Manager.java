package org.template_methode_pattern.tagesablauf.entity.erwärbstätige;

import org.template_methode_pattern.tagesablauf.entity.Erwerbstätige;

public class Manager extends Erwerbstätige {

	@Override
	protected void frühstück() {
		System.out.println("Frühstück: Kaffee");
	}

	@Override
	protected void entspannen() {
		System.out.println("Entspannen: Am Handy spielen");
	}
}
