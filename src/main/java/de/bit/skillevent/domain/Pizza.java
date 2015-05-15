package de.bit.skillevent.domain;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Set;

@NodeEntity
public class Pizza extends BasisDomainObject {

    private String     name;

    private Set<Zutat> zutaten = Sets.newHashSet();

    Pizza() {
    }

    public Pizza(String oId, String name) {
        this(name);
        Preconditions.checkNotNull(oId);
        this.oId = oId;
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

    public Set<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(Set<Zutat> zutaten) {
        this.zutaten = zutaten;
    }
}
