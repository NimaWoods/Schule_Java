package org.template_methode_pattern.heißgetränke.strategy;

abstract class HeißgetränkStrategy {

	public HeißgetränkStrategy() {
		wasserKochen();
		zubereiten();
		einfüllen();
		topping();
	}

	protected void wasserKochen() {}
	protected void zubereiten() {}
	protected void einfüllen() {}
	protected void topping() {}

}
