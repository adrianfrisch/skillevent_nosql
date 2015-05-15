package de.bit.skillevent.domain.exp;

import de.bit.skillevent.domain.Pizza;
import de.bit.skillevent.domain.Zutat;
import de.bit.skillevent.domain.exp.ZutatenCreator.ZUTATEN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static de.bit.skillevent.domain.exp.ZutatenCreator.ZUTATEN.*;

/**
 * Created by pbayer.
 */
public class PizzenCreator {

    private final List<Pizza> pizzen;

    private List<Zutat>       alleMoeglichenZutaten;

    public PizzenCreator(List<Zutat> alleMoeglichenZutaten) {
        this.alleMoeglichenZutaten = alleMoeglichenZutaten;
        List<Pizza> pizzenTemp = new ArrayList<>();
        pizzenTemp.add(new PizzaBuilder(new Pizza("1", "Schinken")).withZutat(SCHINKEN).build());
        pizzenTemp.add(new PizzaBuilder(new Pizza("2", "Salami")).withZutat(SALAMI).build());
        pizzenTemp.add(new PizzaBuilder(new Pizza("3", "4 Stragioni")).withZutat(EDAMER).build());
        pizzenTemp.add(new PizzaBuilder(new Pizza("4", "4 Formaggi")).withZutat(EDAMER).withZutat(GOUDA).withZutat(PARMESAN).build());
        pizzen = Collections.unmodifiableList(pizzenTemp);
    }

    public List<Pizza> allePizzen() {
        return pizzen;
    }

    private class PizzaBuilder {

        private Pizza pizza;

        public PizzaBuilder(Pizza pizza) {
            this.pizza = pizza;
        }

        public PizzaBuilder withZutat(Zutat z) {
            pizza.getZutaten().add(new Zutat(z.getOId()));
            return this;
        }

        public PizzaBuilder withZutat(ZUTATEN zutat) {
            pizza.getZutaten().add(findZutatByOId(zutat));
            return this;
        }

        private Zutat findZutatByOId(ZUTATEN zutat) {
            return alleMoeglichenZutaten.stream().filter(z -> {
                return z.getOId().equals(zutat.toString());
            }).findFirst().get();
        }

        public Pizza build() {
            return pizza;
        }

    }
}
