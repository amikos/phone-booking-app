package app;

import java.util.Scanner;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) {
        PhoneBookingApp app = new PhoneBookingApp();
        System.out.println("Application started.");
        System.out.println(" ");

        PhoneBookingListener listener = System.out::println;
        app.addListener(listener);

        System.out.println("List of phones:");
        app.printAllPhoneInfo();
        System.out.println(" ");

        System.out.println("To exit the application, enter 'quit'");
        System.out.println("To book a phone, use the following command format 'book {model} {user}', for example 'book IPHONE_X Jon'");
        System.out.println("To return a phone, use the following command format: 'return {model}', for example 'return IPHONE_X'");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print(">>: ");
            String[] command = scanner.nextLine().split(" ");

            try {
                switch (command[0]) {
                    case "quit":
                        System.out.println("Application stopped.");
                        return;
                    case "book":
                        app.bookPhone(PhoneModel.valueOf(command[1]), command[2]);
                        break;
                    case "return":
                        app.returnPhone(PhoneModel.valueOf(command[1]));
                        break;
                    default:
                        System.err.println("Invalid command");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Phone not found");
            }

        }
    }

}
