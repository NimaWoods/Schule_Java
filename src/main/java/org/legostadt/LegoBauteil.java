package org.legostadt;

import lombok.Data;

@Data
public class LegoBauteil {
	private double preis;

	public double preis() {
		return preis;
	}
}
