package de.bit.skillevent.domain;

import java.util.Date;
import java.util.List;

public class Bestellung extends BasisDomainObject{
	private Date bestellDatum;
	private double gesamtPreis;
	private List<Pizza> bestelltePizzen;
	
	public Date getBestellDatum() {
		return bestellDatum;
	}

	public void setBestellDatum(Date bestellDatum) {
		this.bestellDatum = bestellDatum;
	}

	public double getGesamtPreis() {
		return gesamtPreis;
	}

	public void setGesamtPreis(double gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}

	public List<Pizza> getBestelltePizzen() {
		return bestelltePizzen;
	}

	public void setBestelltePizzen(List<Pizza> bestelltePizzen) {
		this.bestelltePizzen = bestelltePizzen;
	}
}
