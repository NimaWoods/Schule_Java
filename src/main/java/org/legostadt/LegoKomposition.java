package org.legostadt;

import java.util.ArrayList;
import java.util.List;

public class LegoKomposition extends LegoBauteil {
	private List<LegoBauteil> teile;

	public LegoKomposition() {
		this.teile = new ArrayList<>();
	}

	public void addTeil(LegoBauteil teil) {
		this.teile.add(teil);
	}

	@Override
	public double preis() {
		double preis = 0;
		for (LegoBauteil teil : teile) {
			preis += teil.preis();
		}
		return preis;
	}
}
