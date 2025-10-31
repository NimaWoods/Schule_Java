package org.template_methode_pattern.heißgetränke.strategy;

public class KakoStrategy extends HeißgetränkStrategy {
	@Override
	protected void geschmack() {
		System.out.println("Milch-Kakao-Pulver einrühren.");
	}

	@Override
	protected void zusätze() {
		System.out.println("Sahne hinzufügen.");
	}
}
