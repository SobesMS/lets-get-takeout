import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
    private final Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        this.shoppingBag = new HashMap<>();
    }

    public void addItem(T item) {
        if (shoppingBag.containsKey(item)) {
            int itemCount = shoppingBag.get(item) + 1;
            shoppingBag.put(item, itemCount);
        } else {
            shoppingBag.put(item, 1);
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<T, Integer> pair : shoppingBag.entrySet()) {
            T item = pair.getKey();
            totalPrice = totalPrice + (item.getPrice() * pair.getValue());
        }
        return totalPrice;
    }

    public boolean isBagEmpty() {
        return this.shoppingBag.isEmpty();
    }
}
