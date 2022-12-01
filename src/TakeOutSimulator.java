import java.util.Scanner;

public class TakeOutSimulator {
    private final Customer customer;
    private final FoodMenu menu;
    private final Scanner input;

    public TakeOutSimulator(Customer customer, Scanner input) {
        this.customer = customer;
        this.input = input;
        this.menu = new FoodMenu();
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
        while (true) {
            System.out.print(userInputPrompt);
            if (input.hasNextInt()) {
                int userIntSelection = input.nextInt();
                if (userIntSelection >= 0 && userIntSelection <= menu.getMenuItemCount()) {
                    return intUserInputRetriever.produceOutputOnIntUserInput(userIntSelection);
                } else {
                    System.out.print("Invalid entry. ");
                }
            } else {
                input.next();
                System.out.print("Invalid entry. ");
            }
        }
    }

    public Food getMenuSelection() {
        String userPrompt = "Choose a menu item or enter 0 to checkout: ";
        IntUserInputRetriever<?> intUserInputRetriever = selection -> {
            if (selection > 0 && selection <= menu.getMenuItemCount()) {
                return menu.getFood(selection - 1);
            } else if (selection == 0) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        };
        return (Food) getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
        if (shoppingBag.isBagEmpty()) {
            System.out.println("\nYour remaining money: $" + customer.getMoney());
            System.out.println("Thank you and have a nice day!");
        } else {
            System.out.print("\nProcessing payment");
            for (int i = 0; i < 7; i++) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(".");
            }
            customer.setMoney(customer.getMoney() - shoppingBag.getTotalPrice());
            System.out.println("\nYour remaining money: $" + customer.getMoney());
            System.out.println("Thank you and enjoy your food!");
        }
    }

    public void takeoutPrompt() {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoney = customer.getMoney();
        System.out.println("\nYou have $" + customerMoney + " to spend.");
        System.out.println(menu);
        boolean isStillOrdering = true;
        while (isStillOrdering) {
            Food foodItem = getMenuSelection();
            if (foodItem != null && customerMoney >= foodItem.getPrice()) {
                customerMoney -= foodItem.getPrice();
                shoppingBag.addItem(foodItem);
                System.out.println("Added " + foodItem.getName() + " to your order. " +
                        "You have $" + customerMoney + " to spend.");
            } else if (foodItem == null) {
                isStillOrdering = false;
            } else {
                System.out.println("Balance is too low to add item.");
            }
        }
        checkoutCustomer(shoppingBag);
    }

    public void startTakeOutSimulator() {
        System.out.println("\nHello, " + customer.getName() + "! Welcome to the Coding Cafe.");
        System.out.println("\nToday's menu options!");
        takeoutPrompt();
    }
}
