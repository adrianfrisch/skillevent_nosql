package de.bit.skillevent.domain;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends BasisDomainObject {

    private String name;

    private List<Zutat> zutaten = new ArrayList<>();

    public Pizza(String name) {
        this.name = name;
        this.id = name.toLowerCase();
    }

    public Pizza addIngredientById(String id) {
        zutaten.add(new Zutat().withId(id));
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }
}
