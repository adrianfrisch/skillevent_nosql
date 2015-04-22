package de.bit.skillevent.domain;

import java.util.List;

public class Pizza  extends BasisDomainObject{
	private String name;
	private List<Zutat> zutaten;
	
	public Pizza(String name) {
		this.name = name;
		this.id = name.toLowerCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
