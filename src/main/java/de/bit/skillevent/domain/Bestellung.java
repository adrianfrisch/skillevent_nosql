package de.bit.skillevent.domain;

import java.util.Collection;
import java.util.Date;

public class Bestellung extends BasisDomainObject {
    private Date              bestellDatum;
    private double            gesamtPreis;
    private Collection<Pizza> bestelltePizzen;
    private Kunde             besteller;

    Bestellung() {
    }

    public Bestellung(Kunde besteller, double gesamtPreis) {
        this.besteller = besteller;
        bestellDatum = new Date();
        this.oId = besteller.toString() + bestellDatum.toString();
        this.gesamtPreis = gesamtPreis;
    }

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

    public Collection<Pizza> getBestelltePizzen() {
        return bestelltePizzen;
    }

    public void setBestelltePizzen(Collection<Pizza> bestelltePizzen) {
        this.bestelltePizzen = bestelltePizzen;
    }

    public Kunde getBesteller() {
        return besteller;
    }

    public void setBesteller(Kunde besteller) {
        this.besteller = besteller;
    }
}
