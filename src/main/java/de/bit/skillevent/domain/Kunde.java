package de.bit.skillevent.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.util.List;

public class Kunde extends BasisDomainObject {

    private String           nachName;

    private String           vorName;

    private boolean          vegetarier;

    private List<Bestellung> bestellungen;

    private String           oId;

    public Kunde() {
    }

    public Kunde(String oId, String vorName, String nachName, boolean vegetarier) {
        this(vorName, nachName, vegetarier);
        Preconditions.checkNotNull(oId);
        this.oId = oId;
    }

    public Kunde(String vorName, String nachName, boolean vegetarier) {
        Preconditions.checkArgument(vorName != null && nachName != null);
        this.vorName = vorName;
        this.nachName = nachName;
        this.vegetarier = vegetarier;
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
        return MoreObjects.toStringHelper(this.getClass()).add("vorname", vorName).add("nachName", nachName).add("vegetarier", vegetarier)
                .toString();
    }
}
