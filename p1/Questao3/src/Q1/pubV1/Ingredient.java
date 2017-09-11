package Q1.pubV1;

public class Ingredient {
	
	public static int computePrice(Ingredient[] ingredients) {
		int total = 0;
		for (Ingredient ingredient : ingredients) {
			total += ingredient.getPrice();
		}
		return total;
	}
	
	private String name;	
	private int price;

	public Ingredient(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

}
