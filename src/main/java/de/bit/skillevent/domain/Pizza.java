package de.bit.skillevent.domain;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends BasisDomainObject {

    private String name;

    private List<Zutat> zutaten = new ArrayList<>();

    public Pizza() {
    }

    public Pizza(long id, String name) {
        this(name);
        this.id = id;
    }

    public Pizza(String name) {
        Preconditions.checkNotNull(name);
        this.name = name;
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
