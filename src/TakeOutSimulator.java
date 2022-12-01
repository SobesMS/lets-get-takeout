import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, Scanner input) {
        this.customer = customer;
        this.input = input;
        this.menu = new FoodMenu();
    }

    // TODO - working on user input logic
    private <T> getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever intUserInputRetriever) {
        while (true) {
            System.out.println(userInputPrompt);
            if (input.hasNextInt()) {
                try {
                    intUserInputRetriever.produceOutputOnIntUserInput(input.nextInt());
                } catch (IllegalArgumentException e) {
                    String invalidInput = input.next() + " is not a valid input. Try again!";
                    System.out.println(invalidInput);
                }
            } else {
                System.out.println("Input needs to be an 'int' type.");
                input.next();
            }
        }
    }
}
