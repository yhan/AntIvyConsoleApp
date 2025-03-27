import java.util.Arrays;

public class Dish // implements Cloneable 
{
    private int calories;
    private final double price;
    private String[] ingredients = new String[0];

    public Dish(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }
    
    @Override
    public Dish clone() {
        try {
            return (Dish) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Should never happen
        }
    }
    public void addIngredients(String... ingredients) {
        this.ingredients = Arrays.copyOf(this.ingredients, this.ingredients.length + ingredients.length);
    }
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return String.format("[ Price: %f, Calories: %d ]", price, calories);
    }

    public double getPrice() {
        return price;
    }

    public String[] getIngredients() {
        return this.ingredients;
    }

    public void incrementCalories(int i) {
        this.calories += i;
    }
}
