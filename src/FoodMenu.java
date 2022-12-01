import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu() {
        this.menu = new ArrayList<>();
        menu.add(new Food("Burger", "beef patty, cheese, ketchup, mustard", 7));
        menu.add(new Food("Fries", "deep fried potato wedges", 3));
        menu.add(new Food("Milkshake", "chocolate, vanilla, strawberry", 5));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= menu.size(); i++) {
            str.append(i).append(menu.get(i).toString()).append("\n");
        }
        return str.toString();
    }

    public Food getFood(int index) {
        if (menu.get(index) != null) {
            return menu.get(index);
        } else {
            return null;
        }
    }

    public Food getLowestCostFood() {
        Food food = null;
        for (Food item : menu) {
            if (food == null) {
                food = item;
            } else {
                if (item.getPrice() < food.getPrice()) {
                    food = item;
                }
            }
        }
        return food;
    }
}
