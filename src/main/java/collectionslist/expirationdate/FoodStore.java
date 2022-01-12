package collectionslist.expirationdate;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FoodStore {

    private List<Food> foods = new LinkedList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    public void sellFirst(Food food) {
        if (food.getExpirationDate().equals(LocalDate.now())) {
            foods.add(foods.get(0));
            foods.set(0, food);
        }
    }

    public List<Food> getFoods() {
        return List.copyOf(foods);
    }
}
