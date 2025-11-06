package org.template_methode_pattern.heißgetränke.strategy;

public abstract class HeißgetränkStrategy {

	public HeißgetränkStrategy() {
	}

	public final void zubereiten() {
		wasserKochen();
		geschmack();
		eingießen();
		zusätze();
	}
	protected void wasserKochen() {
		System.out.println("Wasser Kochen");
	}
	protected void geschmack() {}
	protected void eingießen() {
		System.out.println("Eingießen");
	}
	protected void zusätze() {}

}
