import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private final List<Food> menu;

    public FoodMenu() {
        this.menu = new ArrayList<>();
        menu.add(new Food("Burger", "beef patty, cheese, ketchup, mustard", 7));
        menu.add(new Food("Fries", "deep fried potato wedges", 3));
        menu.add(new Food("Milkshake", "chocolate, vanilla, strawberry", 5));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            str.append(i + 1);
            str.append(" - ");
            str.append(menu.get(i).toString());
            str.append("\n");
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

    public int getMenuItemCount() {
        return menu.size();
    }
}
