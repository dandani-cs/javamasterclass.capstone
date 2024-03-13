import com.capstone.screens.BookCarScreen;
import com.capstone.screens.IScreen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static IScreen[] screens = {
            new BookCarScreen()
    };

    public static void main(String[] args) {
        Integer choice = 0;

        while (choice != 7) {
            displayMenu();
            choice = getChoice();
            IScreen screen = screens[choice];
            screen.display();
        }
    }

    public static void displayMenu() {
        System.out.println("""
                1️⃣ - Book Car
                2️⃣ - View All User Booked Cars
                3️⃣ - View All Bookings
                4️⃣ - View Available Cars
                5️⃣ - View Available Electric Cars
                6️⃣ - View all users
                7️⃣ - Exit
                """);
    }

    public static Integer getChoice() {
        int choice;
        System.out.print("Enter choice: ");
        Scanner scanner = new Scanner(System.in);
        try {
             choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid choice, please try again.");
            return 0;
        }
        if (choice < 1 && choice > 7) {
            System.out.println("Invalid choice, please try again.");
            return 0;
        }
        return choice;
    }
}