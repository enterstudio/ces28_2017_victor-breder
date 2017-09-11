package Q1.pubV1;

public class Drink {
	
	public static final int UNLIMITED = -1;
	
	private String name;
	private int price;
	private int maxAmount;
	private double studentDiscount;
	private Ingredient[] ingredients;
	
	public Drink(String name, int price, int maxAmount, double studentDiscount) {
		this.name = name;
		this.price = price;
		this.maxAmount = maxAmount;
		this.studentDiscount = studentDiscount;
		this.ingredients = null;
	}
	
	public Drink(String name, Ingredient[] ingredients, int maxAmount, double studentDiscount) {
		this.name = name;
		this.price = Ingredient.computePrice(ingredients);
		this.maxAmount = maxAmount;
		this.studentDiscount = studentDiscount;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public double getStudentDiscount() {
		return studentDiscount;
	}
	
	public Ingredient[] getIngredients() {
		return ingredients;
	}
}
