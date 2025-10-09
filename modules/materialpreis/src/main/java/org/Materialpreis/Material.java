package org.Materialpreis;

public class Material {
	
	private String name;
	private double price;
	private String unit;
	private int amount;
	private int total;
	
	public Material(String name, double price, String unit) {
		setName(name);
		setPrice(price);
		setUnit(unit);
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name.replace("\"", "");
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return getName() + " (" + getPrice() + "€ per " + getUnit() + ")";
	}
	
}
