package pkg.yhan;

import java.util.Comparator;

public class DishComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        var priceCompared = Double.compare(o2.getPrice(), o1.getPrice()); // descending
        if (priceCompared != 0) {
            return priceCompared;
        }
        return Integer.compare(o1.getCalories(), o2.getCalories()); // ascending
    }
}
