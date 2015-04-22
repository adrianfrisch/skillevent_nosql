package de.bit.skillevent.domain;

import java.util.List;

public class Rezept  extends BasisDomainObject{
	private String pizzaId;
	private List<String> zutatIds;

	public Rezept(String pizzaId){
		this.pizzaId = pizzaId;
	}
	
	public Rezept addIngredient(String zutatId){
		zutatIds.add(zutatId);
		return this;
	}
	public String getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(String pizzaId) {
		this.pizzaId = pizzaId;
	}

	public List<String> getZutatIds() {
		return zutatIds;
	}

	public void setZutatIds(List<String> zutatIds) {
		this.zutatIds = zutatIds;
	}
}
