package org.template_methode_pattern.heißgetränke;

import org.template_methode_pattern.heißgetränke.strategy.CoffeeStrategy;
import org.template_methode_pattern.heißgetränke.strategy.HeißgetränkStrategy;
import org.template_methode_pattern.heißgetränke.strategy.KakoStrategy;
import org.template_methode_pattern.heißgetränke.strategy.TeeStrategy;

public class Main {
	public static void main(String[] args) {
		System.out.println("\nKaffee Zubereiten");
		HeißgetränkStrategy coffee = new CoffeeStrategy();
		coffee.zubereiten();

		System.out.println("\nTee Zubereiten");
		HeißgetränkStrategy tee = new TeeStrategy();
		tee.zubereiten();

		System.out.println("\nKakao Zubereiten");
		HeißgetränkStrategy kakao = new KakoStrategy();
		kakao.zubereiten();
	}
}