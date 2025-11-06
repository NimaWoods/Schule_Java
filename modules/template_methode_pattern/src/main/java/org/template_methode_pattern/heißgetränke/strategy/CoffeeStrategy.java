package org.template_methode_pattern.heißgetränke.strategy;

public class CoffeeStrategy extends HeißgetränkStrategy {
	@Override
	protected void geschmack() {
		System.out.println("Kaffee aufbrühen.");
	}

	@Override
	protected void zusätze() {
		System.out.println("Zucker und Milch hinzufügen.");
	}
}
