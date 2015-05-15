package de.bit.skillevent.domain.exp;

import com.google.common.collect.Lists;
import de.bit.skillevent.domain.Bestellung;
import de.bit.skillevent.domain.Kunde;
import de.bit.skillevent.domain.Pizza;
import de.bit.skillevent.domain.Zutat;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pbayer.
 */
public class BestellungenCreator {

    private List<Bestellung>  bestellungen;

    private final DataFactory dataFactory = new DataFactory();

    private final List<Pizza> pizzen;

    private int               maxAnzahlPizzenBestellung;

    public BestellungenCreator(List<Kunde> kunden, List<Pizza> pizzen, int maxAnzahlBestellungen, int maxAnzahlPizzenBestellung) {
        this.pizzen = pizzen;
        this.maxAnzahlPizzenBestellung = maxAnzahlPizzenBestellung;

        List<Bestellung> bestellungenTemp = new ArrayList<>();
        kunden.forEach(k -> {
            int anzBestellungen, j = 0;
            anzBestellungen = dataFactory.getNumberBetween(1, maxAnzahlBestellungen);
            while (j < anzBestellungen) {
                bestellungenTemp.add(createBestellung(k));
                j++;
            }
        });

        bestellungen = Collections.unmodifiableList(bestellungenTemp);
    }

    public List<Bestellung> alleBestellungen() {
        return bestellungen;
    }

    private Bestellung createBestellung(Kunde kunde) {
        int anzPizzen = dataFactory.getNumberBetween(1, maxAnzahlPizzenBestellung);
        List<Pizza> bestelletePizzen = Lists.newArrayList();

        for (int i = 0; i < anzPizzen; i++) {
            bestelletePizzen.add(dataFactory.getItem(pizzen));
        }

        double preisPizzen = bestelletePizzen.stream().mapToDouble(p -> {
            return p.getZutaten().stream().mapToDouble(Zutat::getPreis).sum();
        }).sum();

        Bestellung bestellung = new Bestellung(kunde, preisPizzen);
        bestellung.setBestelltePizzen(bestelletePizzen);
        return bestellung;
    }
}
