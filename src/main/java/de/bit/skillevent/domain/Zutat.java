package de.bit.skillevent.domain;

import com.google.common.base.Preconditions;

public class Zutat  extends BasisDomainObject{
	private String name;
	private double preis;
	private boolean vegetarisch;

	public Zutat() {
	}

	public Zutat(long id,String name, double preis, boolean vegetarisch) {
		this(name,preis,vegetarisch);
		this.id=id;
	}

	public Zutat(String name, double preis, boolean vegetarisch) {
		Preconditions.checkNotNull(name);
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
