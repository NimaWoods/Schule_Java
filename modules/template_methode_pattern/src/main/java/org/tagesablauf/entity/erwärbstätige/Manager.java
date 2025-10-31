package org.tagesablauf.entity.erwärbstätige;

import org.tagesablauf.entity.Erwerbstätige;

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
