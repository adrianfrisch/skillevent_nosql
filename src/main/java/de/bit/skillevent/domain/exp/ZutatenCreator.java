package de.bit.skillevent.domain.exp;

import de.bit.skillevent.domain.Zutat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static de.bit.skillevent.domain.exp.ZutatenCreator.ZUTATEN.*;

/**
 * Created by pbayer.
 */
public class ZutatenCreator {

    private final List<Zutat> zutaten;

    public enum ZUTATEN {
        SALAMI, SCHINKEN, PILZE, PEPPERONIWURST, MOZZERELLA, PROVOLONE, GOUDA, EDAMER, PARMESAN, BASILIKUM, OREGANO
    }

    public ZutatenCreator() {
        List<Zutat> zutatenTemp = new ArrayList<>();
        zutatenTemp.add(new Zutat(SALAMI.toString(), "Salami", 1.0, false));
        zutatenTemp.add(new Zutat(PEPPERONIWURST.toString(), "Pepperoniwurst", 1.0, false));
        zutatenTemp.add(new Zutat(SCHINKEN.toString(), "Schinken", 1.0, false));
        zutatenTemp.add(new Zutat(PILZE.toString(), "Pilze", 1.0, false));
        zutatenTemp.add(new Zutat(MOZZERELLA.toString(), "Mozzarella", 1.0, false));
        zutatenTemp.add(new Zutat(PROVOLONE.toString(), "Provolone", 1.0, false));
        zutatenTemp.add(new Zutat(GOUDA.toString(), "Gouda", 1.0, false));
        zutatenTemp.add(new Zutat(EDAMER.toString(), "Edamer", 1.0, false));
        zutatenTemp.add(new Zutat(PARMESAN.toString(), "Parmesan", 1.0, false));
        zutatenTemp.add(new Zutat(BASILIKUM.toString(), "Basilikum", 1.0, false));
        zutatenTemp.add(new Zutat(OREGANO.toString(), "Oregano", 1.0, false));
        zutaten = Collections.unmodifiableList(zutatenTemp);
    }

    public List<Zutat> alleZutaten() {
        return zutaten;
    }

}
