package de.bit.skillevent.domain.exp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.bit.skillevent.domain.Bestellung;
import de.bit.skillevent.domain.Kunde;
import de.bit.skillevent.domain.Pizza;
import de.bit.skillevent.domain.Rezept;
import de.bit.skillevent.domain.Zutat;

public class DomainExporter {
	public static void main(String [] args) throws Exception{
		List<Zutat> ingredients = new ArrayList<Zutat>();
		ingredients.add(new Zutat("Salami", 1.0 , false));
		ingredients.add(new Zutat("Pepperoniwurst", 1.0 , false));
		ingredients.add(new Zutat("Schinken", 1.0 , false));
		ingredients.add(new Zutat("Pilze", 1.0 , false));
		ingredients.add(new Zutat("Mozzarella", 1.0 , false));
		ingredients.add(new Zutat("Provolone", 1.0 , false));
		ingredients.add(new Zutat("Gouda", 1.0 , false));
		ingredients.add(new Zutat("Edamer", 1.0 , false));
		ingredients.add(new Zutat("Parmesan", 1.0 , false));
		ingredients.add(new Zutat("Basilikum", 1.0 , false));
		ingredients.add(new Zutat("Oregano", 1.0 , false));
		
		List<Pizza> pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza("Schinken"));
		pizzas.add(new Pizza("Salami"));
		pizzas.add(new Pizza("4 Stragioni"));
		pizzas.add(new Pizza("4 Formaggi"));
		
		List<Rezept> recipies = new ArrayList<Rezept>();
		recipies.add(new Rezept("schinken").addIngredient("schinken").addIngredient("gouda"));
		
		List<Kunde> customers = new ArrayList<Kunde>();
		customers.add(new Kunde("Adrian", "Frischauf", false));
		customers.add(new Kunde("Philipp", "Bayer", false));
		customers.add(new Kunde("Anton", "Obermayer", true));
		
		List<Bestellung> orders = new ArrayList<Bestellung>();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(System.out, ingredients);
	}
}
