public class Food implements PricedItem<Integer> {
    private final String name;
    private final String description;
    private int price;

    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", " + description + "     Cost: $" + price;
    }
}
