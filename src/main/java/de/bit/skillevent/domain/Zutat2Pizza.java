package de.bit.skillevent.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Created by pbayer.
 */
@RelationshipEntity(type = Zutat2Pizza.ZUTAT_2_PIZZA)
public class Zutat2Pizza {

    public static final String ZUTAT_2_PIZZA = "Zutat2Pizza";

    @GraphId
    Long                       id;

    @StartNode
    Zutat                      zutat;

    @EndNode
    Pizza                      pizza;

    public Zutat getZutat() {
        return zutat;
    }

    public Pizza getPizza() {
        return pizza;
    }
}
