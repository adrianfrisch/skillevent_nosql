package de.bit.skillevent.domain.exp;

import com.google.common.collect.Lists;
import de.bit.skillevent.domain.Kunde;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by pbayer.
 */
public class KundenCreator {

    private List<Kunde> kunden;

    public KundenCreator(int anzahl, int wahrscheinlichkeitVegetrarier) {
        int i = 0;
        DataFactory dataFactory = new DataFactory();
        List<Kunde> kundenTemp = Lists.newArrayList();
        while (i < anzahl) {
            kundenTemp.add(new Kunde(UUID.randomUUID().toString(), dataFactory.getFirstName(), dataFactory.getLastName(), dataFactory
                    .chance(wahrscheinlichkeitVegetrarier)));
            i++;
        }
        kunden = Collections.unmodifiableList(kundenTemp);
    }

    public List<Kunde> alleKunden() {
        return kunden;
    }

}
