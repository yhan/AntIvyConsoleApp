import org.junit.jupiter.api.Test;
import pkg.yhan.Dish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DishTests{
    @Test
    public void shallowCopy() {
        assertTrue(true);
        final int CALORIES = 14;
        Dish dish = new Dish(CALORIES,100);
        dish.addIngredients("apple", "banana");

        Dish clone = null;
        try {
            clone = dish.clone();
        } catch (AssertionError e) {
            System.out.println(e);
            return;
        }

        var ingres = dish.getIngredients();
        ingres[0] = "orange";
        
        assertEquals("orange", clone.getIngredients()[0]); // clone changed also
        dish.incrementCalories(1);
        
        assertEquals(CALORIES, clone.getCalories());
        assertEquals(CALORIES + 1, dish.getCalories());
    }
}


