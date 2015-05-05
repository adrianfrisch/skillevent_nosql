package de.bit.skillevent.domain;

import java.util.List;

public class Kunde extends BasisDomainObject {
	private String nachName;
	private String vorName;
	private boolean vegetarier;
	private List<Bestellung> bestellungen;

	public Kunde(String vorName, String nachName, boolean vegetarier) {
		this.vorName = vorName;
		this.nachName = nachName;
		this.vegetarier = vegetarier;
		this.id = vorName.toLowerCase() + nachName.toLowerCase();
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public boolean isVegetarier() {
		return vegetarier;
	}

	public void setVegetarier(boolean vegetarier) {
		this.vegetarier = vegetarier;
	}

	public List<Bestellung> getBestellungen() {
		return bestellungen;
	}

	public void setBestellungen(List<Bestellung> bestellungen) {
		this.bestellungen = bestellungen;
	}

	public String toString() {
		return "Kunde [vorName:" + vorName + ";nachName:" + nachName
				+ ";vegetarier:" + vegetarier + "]";
	}
}
