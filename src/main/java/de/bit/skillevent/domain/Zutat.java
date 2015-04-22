package de.bit.skillevent.domain;

public class Zutat  extends BasisDomainObject{
	private String name;
	private double preis;
	private boolean vegetarisch;

	public Zutat(String name, double preis, boolean vegetarisch) {
		this.id = name.toLowerCase();
		this.name = name;
		this.preis = preis;
		this.vegetarisch = vegetarisch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public boolean isVegetarisch() {
		return vegetarisch;
	}

	public void setVegetarisch(boolean vegetarisch) {
		this.vegetarisch = vegetarisch;
	}
}