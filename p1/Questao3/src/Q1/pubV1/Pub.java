package Q1.pubV1;

import java.util.HashMap;

public class Pub {

	private HashMap<String, Drink> drinks;

	public Pub() {
		Ingredient RumIngredient = new Ingredient("rum", 65);
		Ingredient GrenadineIngredient = new Ingredient("grenadine", 10);
		Ingredient LimeJuiceIngredient = new Ingredient("lime juice", 10);
		Ingredient GreenStuffIngredient = new Ingredient("green stuff", 10);
		Ingredient TonicWaterIngredient = new Ingredient("tonic water", 20);
		Ingredient GinIngredient = new Ingredient("gin", 85);
		
		drinks = new HashMap<String, Drink>();
		drinks.put("hansa", new Drink("hansa", 74, Drink.UNLIMITED, 0.10));
		drinks.put("grans", new Drink("grans", 103, Drink.UNLIMITED, 0.10));
		drinks.put("strongbow", new Drink("strongbow", 110, Drink.UNLIMITED, 0.10));
		Ingredient[] gt_ingredients = { GinIngredient, TonicWaterIngredient, GreenStuffIngredient };
		drinks.put("gt", new Drink("gt", gt_ingredients, 2, 0));
		Ingredient[] barcadi_special_ingredients = { GinIngredient, RumIngredient, GrenadineIngredient, LimeJuiceIngredient};
		drinks.put("bacardi_special", new Drink("bacardi_special", barcadi_special_ingredients, 2, 0));
	}

	public int computeCost(String drinkName, boolean student, int amount) {
		if (!drinks.containsKey(drinkName)) {
			throw new RuntimeException("No such drink exists");
		}
		
		Drink drink = drinks.get(drinkName);
		if (drink.getMaxAmount() != Drink.UNLIMITED && amount > drink.getMaxAmount()) {
			throw new RuntimeException("Too many drinks, max 2.");
		}
		double discount = student ? drink.getStudentDiscount() : 0;
		int price = (int) Math.ceil(drink.getPrice() * (1 - discount));
		return price * amount;
	}

}
