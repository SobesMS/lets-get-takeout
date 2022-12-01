import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nWhat is your name? ");
        String name = input.next();
        System.out.print("How much money do you have? $");
        int money = 0;
        boolean isInt = true;
        while (isInt) {
            if (input.hasNextInt()) {
                money = input.nextInt();
                isInt = false;
            } else {
                input.next();
                System.out.print("Invalid entry. Please enter a number value: $");
            }
        }
        Customer customer = new Customer(name, money);
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, input);
        takeOutSimulator.startTakeOutSimulator();
    }
}