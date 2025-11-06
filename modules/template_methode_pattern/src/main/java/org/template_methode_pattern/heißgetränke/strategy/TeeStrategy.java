package org.template_methode_pattern.heißgetränke.strategy;

public class TeeStrategy extends HeißgetränkStrategy {
	@Override
	protected void geschmack() {
		System.out.println("Tee ziehen lassen.");
	}

	@Override
	protected void zusätze() {
		System.out.println("Zitrone hinzufügen.");
	}
}
